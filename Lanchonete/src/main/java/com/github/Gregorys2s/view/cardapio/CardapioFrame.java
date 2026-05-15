/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.github.Gregorys2s.view.cardapio;

import com.github.Gregorys2s.controller.CardapioController;
import com.github.Gregorys2s.entity.Cardapio;
import com.github.Gregorys2s.util.*;
import java.awt.Frame;
import java.awt.Window;
import java.util.*;
import javax.swing.JDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import static javax.swing.SwingUtilities.getWindowAncestor;
import javax.swing.table.TableRowSorter;

public class CardapioFrame extends javax.swing.JInternalFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CardapioFrame.class.getName());
    private final CardapioController cardapioController;
    private TableRowSorter<CardapioView> sorter;
    private CardapioView cardapioView;

    public CardapioFrame(CardapioController cardapioController) {
        this.cardapioController = cardapioController;
        
        initComponents();
        CardapioConfig();
    }
    
    private void CardapioConfig()
    {
        this.cardapioView = new CardapioView(cardapioController);
        sorter = new TableRowSorter<>(cardapioView);
        cardapioTb.setModel(cardapioView);
        cardapioTb.setRowSorter(sorter);
        
        List<RowSorter.SortKey> ordemID = new ArrayList<>();
        
        int colunaId = 0;
        ordemID.add(new RowSorter.SortKey(colunaId, SortOrder.ASCENDING));
        
        sorter.setSortKeys(ordemID);
        sorter.sort();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        comboFiltroSelector = new javax.swing.JComboBox<>();
        cardapioScrollPane = new javax.swing.JScrollPane();
        cardapioTb = new javax.swing.JTable();
        stringRecebida = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        adicionarItemBttn = new javax.swing.JButton();
        voltarBttn = new javax.swing.JButton();
        editBttn = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cardapio");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );

        comboFiltroSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Preço", "Nome", "Tipo", " " }));
        comboFiltroSelector.setSelectedIndex(1);
        comboFiltroSelector.addActionListener(this::comboFiltroSelectorActionPerformed);

        cardapioTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Tipo", "Preco"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        cardapioScrollPane.setViewportView(cardapioTb);
        cardapioTb.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        stringRecebida.addActionListener(this::stringRecebidaActionPerformed);
        stringRecebida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stringRecebidaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stringRecebidaKeyTyped(evt);
            }
        });

        jLabel1.setText("Pesquisa:");

        jLabel2.setText("Filtro:");

        adicionarItemBttn.setText("Adicionar Item");
        adicionarItemBttn.setPreferredSize(new java.awt.Dimension(111, 23));
        adicionarItemBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                adicionarItemBttnMouseReleased(evt);
            }
        });

        voltarBttn.setText("Voltar ao menu");
        voltarBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                voltarBttnMouseReleased(evt);
            }
        });
        voltarBttn.addActionListener(this::voltarBttnActionPerformed);

        editBttn.setText("Editar item");
        editBttn.setPreferredSize(new java.awt.Dimension(111, 23));
        editBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                editBttnMouseReleased(evt);
            }
        });
        editBttn.addActionListener(this::editBttnActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cardapioScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(adicionarItemBttn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(editBttn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(voltarBttn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(stringRecebida, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboFiltroSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboFiltroSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stringRecebida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adicionarItemBttn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(voltarBttn)
                    .addComponent(editBttn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardapioScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboFiltroSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFiltroSelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboFiltroSelectorActionPerformed

    private void stringRecebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stringRecebidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stringRecebidaActionPerformed

    private void stringRecebidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stringRecebidaKeyTyped
 
    }//GEN-LAST:event_stringRecebidaKeyTyped

    private void stringRecebidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stringRecebidaKeyReleased
            String receptor = stringRecebida.getText().trim();
            String filtro = comboFiltroSelector.getSelectedItem().toString();

            if(receptor.isBlank() || receptor.isEmpty())
            {
                sorter.setRowFilter(null);
            }
            switch (filtro) {
            case "Nome" -> {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + receptor, 1));
            }
            case "Tipo" -> {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + receptor, 2));
            }
            case "Preço" -> {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" +receptor, 3));
            }
            case "ID" -> {
                sorter.setRowFilter(RowFilter.regexFilter("^" + receptor + "$", 0));
            }
        }
    }//GEN-LAST:event_stringRecebidaKeyReleased

    private void adicionarItemBttnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adicionarItemBttnMouseReleased
        AdicionarItemPanel panel = new AdicionarItemPanel(cardapioController);
        Window janela = getWindowAncestor(this);
        
        adicionarJanela(panel, janela, "Adicionar item");

    }//GEN-LAST:event_adicionarItemBttnMouseReleased

    private void voltarBttnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarBttnMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_voltarBttnMouseReleased

    private void voltarBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarBttnActionPerformed
        this.dispose();
    }//GEN-LAST:event_voltarBttnActionPerformed

    private void editBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBttnActionPerformed
        try{
            Integer idTabela = SelecaoTabela.selecionarId(cardapioTb);

            // 2. Busca o objeto no controller
            var produto = cardapioController.produtoSelecionadoId(idTabela);

            if (produto != null) {
                // 3. Abre o painel
                EditarItemPanel panel = new EditarItemPanel(cardapioController, produto.getId());
                Window pai = getWindowAncestor(this);
                adicionarJanela(panel, pai, "Editar Item");
            }
        }catch (Exception e)
        {
            showMessageDialog(this, "por favor selecione um item");
        }
    }//GEN-LAST:event_editBttnActionPerformed

    private void editBttnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBttnMouseReleased

    }//GEN-LAST:event_editBttnMouseReleased
    private void adicionarJanela(JPanel panel, Window janelaPai, String tituloJanela)
    {
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField stringRecebida;
    private javax.swing.JButton voltarBttn;
    // End of variables declaration//GEN-END:variables
}
