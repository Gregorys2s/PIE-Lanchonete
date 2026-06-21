/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.github.Gregorys2s.view.cardapio;

import com.github.Gregorys2s.controller.cardapio.Implementacoes.CardapioController;
import com.github.Gregorys2s.util.*;
import java.awt.Frame;
import java.awt.Window;
import java.util.*;
import javax.swing.JDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import com.github.Gregorys2s.view.tema.TemaSistema;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import static javax.swing.SwingUtilities.getWindowAncestor;
import javax.swing.table.TableRowSorter;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class CardapioFrame extends javax.swing.JInternalFrame {
    
    private final CardapioController cardapioController;
    private TableRowSorter<CardapioView> sorter;
    private CardapioView cardapioView;

    public CardapioFrame(CardapioController cardapioController) {
        this.cardapioController = cardapioController;
        initComponents();
        configurarVisual();
    }
    
    private void configurarVisual() {
        this.cardapioView = new CardapioView(cardapioController);
        sorter = new TableRowSorter<>(cardapioView);
        cardapioTb.setModel(cardapioView);
        cardapioTb.setRowSorter(sorter);
        
        List<RowSorter.SortKey> ordemID = new ArrayList<>();
        ordemID.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorter.setSortKeys(ordemID);
        sorter.sort();

        TemaSistema.aplicar(this);
        
        // Ajustes finos
        cardapioTb.setRowHeight(38);
        cardapioScrollPane.setBorder(BorderFactory.createLineBorder(TemaSistema.borda()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboFiltroSelector = new javax.swing.JComboBox<>();
        cardapioScrollPane = new javax.swing.JScrollPane();
        cardapioTb = new javax.swing.JTable();
        stringRecebida = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        adicionarItemBttn = new javax.swing.JButton();
        voltarBttn = new javax.swing.JButton();
        editBttn = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cardápio");

        comboFiltroSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Preço", "Nome", "Tipo", "ID" }));
        comboFiltroSelector.setSelectedIndex(1);

        cardapioTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Tipo", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cardapioScrollPane.setViewportView(cardapioTb);

        stringRecebida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stringRecebidaKeyReleased(evt);
            }
        });

        jLabel1.setText("Pesquisa:");

        jLabel2.setText("Filtro:");

        adicionarItemBttn.setText("Novo Produto");
        adicionarItemBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarItemBttnActionPerformed(evt);
            }
        });

        voltarBttn.setText("Voltar");
        voltarBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarBttnActionPerformed(evt);
            }
        });

        editBttn.setText("Editar Produto");
        editBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBttnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cardapioScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(adicionarItemBttn)
                        .addGap(18, 18, 18)
                        .addComponent(editBttn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(voltarBttn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(stringRecebida, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboFiltroSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(stringRecebida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(comboFiltroSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adicionarItemBttn)
                    .addComponent(editBttn)
                    .addComponent(voltarBttn))
                .addGap(18, 18, 18)
                .addComponent(cardapioScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stringRecebidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stringRecebidaKeyReleased
        String receptor = stringRecebida.getText().trim();
        String filtro = comboFiltroSelector.getSelectedItem().toString();

        if(receptor.isEmpty()) {
            sorter.setRowFilter(null);
            return;
        }
        
        switch (filtro) {
            case "Nome" -> sorter.setRowFilter(RowFilter.regexFilter("(?i)" + receptor, 1));
            case "Tipo" -> sorter.setRowFilter(RowFilter.regexFilter("(?i)" + receptor, 2));
            case "Preço" -> sorter.setRowFilter(RowFilter.regexFilter("(?i)" + receptor, 3));
            case "ID" -> sorter.setRowFilter(RowFilter.regexFilter("^" + receptor + "$", 0));
        }
    }//GEN-LAST:event_stringRecebidaKeyReleased

    private void adicionarItemBttnActionPerformed(java.awt.event.ActionEvent evt) {
        AdicionarItemPanel panel = new AdicionarItemPanel(cardapioController);
        Window janela = getWindowAncestor(this);
        adicionarJanela(panel, janela, "Adicionar item");
    }

    private void voltarBttnActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void editBttnActionPerformed(java.awt.event.ActionEvent evt) {
        int linha = cardapioTb.getSelectedRow();
        if (linha == -1) {
            showMessageDialog(this, "Por favor, selecione um item na tabela.");
            return;
        }
        
        try {
            Integer idTabela = (Integer) cardapioTb.getValueAt(linha, 0);
            var produto = cardapioController.produtoSelecionadoId(idTabela);

            if (produto != null) {
                EditarItemPanel panel = new EditarItemPanel(cardapioController, produto.getId());
                Window pai = getWindowAncestor(this);
                adicionarJanela(panel, pai, "Editar Item");
            }
        } catch (Exception e) {
            showMessageDialog(this, "Erro ao carregar dados do produto.");
        }
    }

    private void adicionarJanela(JPanel panel, Window janelaPai, String tituloJanela) {
        JDialog dialogoAdd = new JDialog((Frame)janelaPai, tituloJanela, true);
        dialogoAdd.getContentPane().add(panel);
        dialogoAdd.pack();
        dialogoAdd.setLocationRelativeTo(this);
        dialogoAdd.setResizable(false);
        dialogoAdd.setVisible(true);
        
        cardapioView.atualizarDadosTabela();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarItemBttn;
    private javax.swing.JScrollPane cardapioScrollPane;
    private javax.swing.JTable cardapioTb;
    private javax.swing.JComboBox<String> comboFiltroSelector;
    private javax.swing.JButton editBttn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField stringRecebida;
    private javax.swing.JButton voltarBttn;
    // End of variables declaration//GEN-END:variables
}
