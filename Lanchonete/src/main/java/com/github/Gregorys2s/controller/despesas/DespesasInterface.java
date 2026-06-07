package com.github.Gregorys2s.controller.despesas;

import com.github.Gregorys2s.controller.entries.InputEnum;
import com.github.Gregorys2s.exceptions.DespesasControllerException;

import java.math.BigDecimal;

public interface DespesasInterface {
    public void novaDespesa(BigDecimal valorDespesa);

    public void verificarInput(String valorInput, BigDecimal valor);
}
