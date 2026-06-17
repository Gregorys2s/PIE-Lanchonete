package com.github.Gregorys2s.controller.caixa;

import com.github.Gregorys2s.controller.caixa.DTO.AbrirCaixaRequest;
import com.github.Gregorys2s.controller.caixa.DTO.CaixaResponse;
import com.github.Gregorys2s.controller.caixa.DTO.MovimentoCaixaRequest;

public interface CaixaController {

    CaixaResponse abrirCaixa(
            AbrirCaixaRequest request
    );

    CaixaResponse registrarDespesa(
            MovimentoCaixaRequest request
    );

    CaixaResponse obterCaixa();
}