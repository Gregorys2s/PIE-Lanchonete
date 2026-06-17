package com.github.Gregorys2s.controller.caixa.Implementacao;

import com.github.Gregorys2s.controller.caixa.CaixaController;
import com.github.Gregorys2s.controller.caixa.DTO.AbrirCaixaRequest;
import com.github.Gregorys2s.controller.caixa.DTO.CaixaResponse;
import com.github.Gregorys2s.controller.caixa.DTO.MovimentoCaixaRequest;
import com.github.Gregorys2s.model.service.caixa.CaixaService;

public class CaixaControllerImpl
        implements CaixaController {

    private final CaixaService caixaService;

    public CaixaControllerImpl(
            CaixaService caixaService
    ) {
        this.caixaService = caixaService;
    }

    @Override
    public CaixaResponse abrirCaixa(
            AbrirCaixaRequest request
    ) {

        var caixa =
                caixaService.abrirCaixa(
                        request.valorInicial()
                );

        return new CaixaResponse(
                caixa.getSaldo()
        );
    }

    @Override
    public CaixaResponse registrarDespesa(
            MovimentoCaixaRequest request
    ) {

        var caixa =
                caixaService.registrarDespesa(
                        request.valor()
                );

        return new CaixaResponse(
                caixa.getSaldo()
        );
    }

    @Override
    public CaixaResponse obterCaixa() {

        var caixa =
                caixaService.obterCaixa();

        return new CaixaResponse(
                caixa.getSaldo()
        );
    }
}