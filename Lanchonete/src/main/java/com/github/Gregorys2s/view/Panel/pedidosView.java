/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.github.Gregorys2s.view.Panel;

import com.github.Gregorys2s.controller.CaixaController;
import com.github.Gregorys2s.controller.CardapioController;
import com.github.Gregorys2s.controller.PedidosController;
import com.github.Gregorys2s.entity.Cardapio;
import com.github.Gregorys2s.entity.ItemPedidos;
import com.github.Gregorys2s.entity.Pagamento;
import com.github.Gregorys2s.entity.Pedidos;
import com.github.Gregorys2s.util.LeitoresSwing;
import com.github.Gregorys2s.view.CardapioView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gregory
 */
public class pedidosView extends javax.swing.JInternalFrame {

    /**
     * Creates new form pedidosView
     */

    Pedidos pedido = new Pedidos();
    PedidosController pedidosController;
    CardapioView cardapioView;
    CardapioController cardapioController;
    Pagamento pagamento;
    CaixaController caixa;

    public pedidosView(PedidosController pedidosController, CardapioView cardapioView, CardapioController cardapioController, Pagamento pagamento, CaixaController caixa){
            this.pedidosController = pedidosController;
            this.cardapioView = cardapioView;
            this.cardapioController = cardapioController;
            this.pagamento = pagamento;
            this.caixa = caixa;
            initComponents();

        pedido.setItens(new ArrayList<>());

            carregarTabela();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FinalizarPedido = new javax.swing.JButton();
        AdicionarAdicionais = new javax.swing.JButton();
        AdicionarItem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProdutos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaPedidos = new javax.swing.JTable();
        Pedido = new javax.swing.JLabel();

        FinalizarPedido.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        FinalizarPedido.setText("finalizar pedido");
        FinalizarPedido.addActionListener(this::FinalizarPedidoActionPerformed);

        AdicionarAdicionais.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AdicionarAdicionais.setLabel("Adicionais");
        AdicionarAdicionais.addActionListener(this::AdicionarAdicionaisActionPerformed);

        AdicionarItem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AdicionarItem.setText("Adicionar item");
        AdicionarItem.addActionListener(this::AdicionarItemActionPerformed);

        tbProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "Valor"
            }
        ));
        jScrollPane1.setViewportView(tbProdutos);

        tabelaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Item", "Quantidade", "preco"
            }
        ));
        jScrollPane2.setViewportView(tabelaPedidos);

        Pedido.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Pedido.setText("Pedido");
        Pedido.setFocusTraversalPolicyProvider(true);
        Pedido.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AdicionarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdicionarAdicionais, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FinalizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Pedido)
                .addGap(283, 283, 283))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AdicionarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AdicionarAdicionais, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(FinalizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Pedido, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregarTabela()
    {
        System.out.println("LISTA: " + cardapioController.obterLista().size());
        DefaultTableModel model = (DefaultTableModel) tbProdutos.getModel();

        model.setRowCount(0); // limpa antes

        List<Cardapio> lista = cardapioController.obterLista();

        for (Cardapio p : lista) {

            model.addRow(new Object[]{
                    p.getNome(),
                    p.getPreco()
            });
        }
        System.out.println("LISTA: " + cardapioController.obterLista().size());
    }

    private void adicionarPedidoNaTabela(Cardapio p, int quantidade) {

        DefaultTableModel model = (DefaultTableModel) tabelaPedidos.getModel();

        model.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                quantidade,
                p.getPreco().multiply(new BigDecimal(quantidade))
        });
    }


    private void AdicionarAdicionaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarAdicionaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdicionarAdicionaisActionPerformed

    private void AdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarItemActionPerformed

        ItemPedidos item = new ItemPedidos();

        int linha = tbProdutos.getSelectedRow();
        
        if (linha == -1){
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione algum produto");
            return;
        }


        Integer quantidade = LeitoresSwing.lerInteger("Digite a quantidade");

        if (quantidade == null) {
            return;
        }

        Cardapio produto = cardapioController.obterLista().get(linha);
        item.setProduto(produto);
        item.setQuantidade(quantidade);
        item.setPedido(pedido);
        pedido.getItens().add(item);

        adicionarPedidoNaTabela(produto,quantidade);
    }//GEN-LAST:event_AdicionarItemActionPerformed

    private void FinalizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalizarPedidoActionPerformed
        pedidosController.guardarPedido(pedido);
                    return;
    }//GEN-LAST:event_FinalizarPedidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarAdicionais;
    private javax.swing.JButton AdicionarItem;
    private javax.swing.JButton FinalizarPedido;
    private javax.swing.JLabel Pedido;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaPedidos;
    private javax.swing.JTable tbProdutos;
    // End of variables declaration//GEN-END:variables
}
