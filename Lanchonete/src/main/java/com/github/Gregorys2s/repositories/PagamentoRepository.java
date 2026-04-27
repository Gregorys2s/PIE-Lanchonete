package com.github.Gregorys2s.repositories;

import com.github.Gregorys2s.entity.Pagamento;

import java.util.ArrayList;
import java.util.List;

public class PagamentoRepository {
    private final List<Pagamento> pagamentos = new ArrayList<>();

    public void salvar (Pagamento pagamento){
        pagamentos.add(pagamento);
        System.out.println("pagamento salvo");
    }

    public List<Pagamento> listarTodos(){
        return pagamentos;
    }
}
