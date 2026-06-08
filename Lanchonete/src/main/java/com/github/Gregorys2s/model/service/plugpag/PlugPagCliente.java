package com.github.Gregorys2s.model.service.plugpag;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class PlugPagCliente {

    private static final String URL_ANDROID = "http://192.168.0.10:8080/pagamento";
    private static final int CONNECT_TIMEOUT_MS = 5_000;
    private static final int READ_TIMEOUT_MS    = 90_000;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public ResultadoPagamento realizarPagamento(BigDecimal valor, TipoPagamentoPlugPag tipoPagamento) {
        int valorEmCentavos = valor.multiply(new BigDecimal("100")).intValue();

        Map<String, Object> corpo = Map.of(
                "valor", valorEmCentavos,
                "tipo",  tipoPagamento.getCodigoPlugPag()
        );

        try {
            String jsonEnvio = objectMapper.writeValueAsString(corpo);

            URL url = new URL(URL_ANDROID);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setConnectTimeout(CONNECT_TIMEOUT_MS);
            conn.setReadTimeout(READ_TIMEOUT_MS);
            conn.setDoOutput(true);

            try (OutputStream os = conn.getOutputStream()) {
                os.write(jsonEnvio.getBytes(StandardCharsets.UTF_8));
            }

            int httpStatus = conn.getResponseCode();

            InputStream is = (httpStatus >= 200 && httpStatus < 300)
                    ? conn.getInputStream()
                    : conn.getErrorStream();

            String respostaJson = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            conn.disconnect();

            if (httpStatus == 200) {
                @SuppressWarnings("unchecked")
                Map<String, Object> resposta = objectMapper.readValue(respostaJson, Map.class);

                boolean aprovado = Boolean.TRUE.equals(resposta.get("aprovado"));
                String nsu       = (String) resposta.getOrDefault("nsu", "");
                String codigoAut = (String) resposta.getOrDefault("codigoAutorizacao", "");
                String mensagem  = (String) resposta.getOrDefault("mensagem", "");

                return aprovado
                        ? ResultadoPagamento.aprovado(nsu, codigoAut)
                        : ResultadoPagamento.recusado(mensagem);
            } else {
                return ResultadoPagamento.erro("Erro HTTP " + httpStatus + ": " + respostaJson);
            }

        } catch (java.net.ConnectException e) {
            return ResultadoPagamento.erro("Maquininha não encontrada na rede. Verifique a conexão Wi-Fi.");
        } catch (java.net.SocketTimeoutException e) {
            return ResultadoPagamento.erro("Tempo esgotado aguardando a maquininha.");
        } catch (Exception e) {
            return ResultadoPagamento.erro("Erro inesperado: " + e.getMessage());
        }
    }

    public ResultadoPagamento cancelar(String nsu) {
        try {
            String jsonEnvio = objectMapper.writeValueAsString(Map.of("nsu", nsu));

            URL url = new URL(URL_ANDROID.replace("/pagamento", "/cancelamento"));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setConnectTimeout(CONNECT_TIMEOUT_MS);
            conn.setReadTimeout(READ_TIMEOUT_MS);
            conn.setDoOutput(true);

            try (OutputStream os = conn.getOutputStream()) {
                os.write(jsonEnvio.getBytes(StandardCharsets.UTF_8));
            }

            int status = conn.getResponseCode();
            conn.disconnect();
            return status == 200
                    ? ResultadoPagamento.aprovado(nsu, "CANCELADO")
                    : ResultadoPagamento.erro("Cancelamento falhou (HTTP " + status + ")");
        } catch (Exception e) {
            return ResultadoPagamento.erro("Erro ao cancelar: " + e.getMessage());
        }
    }
}