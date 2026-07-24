package com.github.Gregorys2s.controller.caixa.Implementacao;

import com.github.Gregorys2s.controller.caixa.CaixaController;
import com.github.Gregorys2s.controller.caixa.DTO.AbrirCaixaRequest;
import com.github.Gregorys2s.controller.caixa.DTO.CaixaResponse;
import com.github.Gregorys2s.controller.caixa.DTO.MovimentoCaixaRequest;
import com.github.Gregorys2s.controller.caixa.DTO.MovimentoCaixaResponse;
import com.github.Gregorys2s.model.entity.Caixa.Caixa;
import com.github.Gregorys2s.model.service.caixa.CaixaService;

import java.util.List;

public class CaixaControllerImpl implements CaixaController {

    private final CaixaService caixaService;

    public CaixaControllerImpl(CaixaService caixaService) {
        this.caixaService = caixaService;
    }

    @Override
    public CaixaResponse abrirCaixa(AbrirCaixaRequest request) {
        Caixa caixa = caixaService.abrirCaixa(request.valorInicial());
        return montarResponse(caixa);
    }

    @Override
    public CaixaResponse registrarDespesa(MovimentoCaixaRequest request) {
        Caixa caixa = caixaService.registrarDespesa(request.valor());
        return montarResponse(caixa);
    }

    @Override
    public CaixaResponse registrarReceita(MovimentoCaixaRequest request) {
        Caixa caixa = caixaService.registrarReceita(request.valor());
        return montarResponse(caixa);
    }

    @Override
    public CaixaResponse obterCaixa() {
        return montarResponse(caixaService.obterCaixa());
    }

    @Override
    public boolean isAberto() {
        return caixaService.isAberto();
    }

    private CaixaResponse montarResponse(Caixa caixa) {
        List<MovimentoCaixaResponse> movimentos = caixa.getMovimentos()
                .stream()
                .map(movimento -> new MovimentoCaixaResponse(
                        movimento.dataHora(),
                        movimento.tipo().name(),
                        movimento.valor(),
                        movimento.saldoAposMovimento()
                ))
                .toList();

        return new CaixaResponse(
                caixa.isAberto(),
                caixa.getSaldo(),
                caixa.getValorAbertura(),
                caixa.getTotalEntradas(),
                caixa.getTotalDespesas(),
                movimentos
        );
    }
}