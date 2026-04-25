package com.github.Gregorys2s;

    import com.github.Gregorys2s.controller.PagamentoController;
    import com.github.Gregorys2s.entity.Pagamento;
    import com.github.Gregorys2s.dto.PagamentoDto;
    import com.github.Gregorys2s.repositories.PagamentoRepository;
    import com.github.Gregorys2s.service.PagamentoService;
    import com.github.Gregorys2s.service.PagamentoServiceImpl;

    import java.math.BigDecimal;


public class Main {
    public static void main(String[] args) {
        //abre a caixa apenas o codigo roda, pede o valor da caixa inicial, se for cancelado ele faz um break e finaliza o codigo
        //aqui sera inicializado no o programa e a conexao com o banco de dados
        //ela sera uma classe conection e sera fechada no final do codigo
        //aqui e inizializado a classe que contem o menu
        //ele pede a opcao escolhida e processa para os proximos passo.
        //Estrutura de modelagem para o projecto
        //

        //teste base pagamento
        PagamentoRepository pagamentoRepository = new PagamentoRepository();
        PagamentoService pagamentoService = new PagamentoServiceImpl(pagamentoRepository);
        PagamentoController pagamentoController = new PagamentoController(pagamentoService);

        PagamentoDto dto = new PagamentoDto(
                1L, new BigDecimal("100.00"),"credito"
        );

        Pagamento pagamento = pagamentoController.realizarPagamento(dto);
        System.out.println(pagamento);
    }
}