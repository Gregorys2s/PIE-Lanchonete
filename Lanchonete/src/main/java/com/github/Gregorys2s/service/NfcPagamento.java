package com.github.Gregorys2s.service;

import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;

public class NfcPagamento {
    private static final String URL_ANDROID =
            "http://192.168.0.10:8080/pagamento";

    public boolean realizarPagamento(BigDecimal valor){
        try{
            URL url = new URL(URL_ANDROID);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty(
                    "Content-Type",
                    "application/jason"
            );

            conn.setDoOutput(true);
            String json =
                    "{\"valor\":\"" +
                            valor.toPlainString()
                            + "\"}";

            OutputStream os = conn.getOutputStream();

            os.write(json.getBytes());

            os.flush();
            os.close();

            int responseCode = conn.getResponseCode();

            return responseCode == 200;
        }catch (Exception e){
            e.printStackTrace();

            return false;
        }
    }
}
