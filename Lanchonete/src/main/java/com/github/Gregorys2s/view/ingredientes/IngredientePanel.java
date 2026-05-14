/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.Gregorys2s.view.ingredientes;

import com.github.Gregorys2s.controller.IngredientesController;
import com.github.Gregorys2s.entity.Ingredientes;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class IngredientePanel extends JFrame {

    private final IngredientesController controller;
    private JTable tabela;
    private DefaultTableModel modeloTabela;
    private TableRowSorter<DefaultTableModel> sorter;  // variável que fornece funções organizar e filtrar linhas
    private JTextField txtPesquisa;
    private JComboBox<String> comboFiltro;

    // Labels de Estatísticas no Rodapé
    private JLabel lblTotalTipos;
    private JLabel lblEstoqueTotal;
    private JLabel lblEsgotados;

    public  IngredientePanel(IngredientesController controller) {
        this.controller = controller;
        configurarJanelaPara1600x900();
        inicializarInterface();
        atualizarTabela(controller.listarIngredientes());
    }

    private void configurarJanelaPara1600x900() {
        setTitle("Gestão de Ingredientes - Painel Central");
        // Tamanho calculado para telas 1600x900
        setSize(1100, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza certo no monitor
        setLayout(new BorderLayout(15, 15));

        // Adiciona margens internas globais para o visual
        ((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
    }

    private void inicializarInterface() {
        // Fonte otimizada para monitor de 19.5 polegadas
        Font fontePadrao = new Font("Segoe UI", Font.PLAIN, 14);
        Font fonteNegrito = new Font("Segoe UI", Font.BOLD, 14);

        // 1. TOPO: BARRA DE PESQUISA E FILTROS
        JPanel painelTopo = new JPanel(new BorderLayout(10, 0));

        JPanel painelBusca = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JLabel lblBuscar = new JLabel("Buscar:");
        lblBuscar.setFont(fonteNegrito);

        txtPesquisa = new JTextField(25);
        txtPesquisa.setFont(fontePadrao);

        JLabel lblFiltro = new JLabel("na coluna:");
        lblFiltro.setFont(fontePadrao);

        comboFiltro = new JComboBox<>(new String[]{"Nome", "ID", "Status"});
        comboFiltro.setFont(fontePadrao);

        painelBusca.add(lblBuscar);
        painelBusca.add(txtPesquisa);
        painelBusca.add(lblFiltro);
        painelBusca.add(comboFiltro);

        JButton btnNovo = new JButton("+ Cadastrar Novo");
        btnNovo.setFont(fonteNegrito);
        btnNovo.setBackground(new Color(40, 167, 69)); // Verde bonito
        btnNovo.setForeground(Color.WHITE);
        btnNovo.setFocusPainted(false);

        painelTopo.add(painelBusca, BorderLayout.WEST);
        painelTopo.add(btnNovo, BorderLayout.EAST);
        add(painelTopo, BorderLayout.NORTH);

        // 2. CENTRO: TABELA DE INGREDIENTES

        String[] colunas = {"ID", "Nome do Ingrediente", "Qtd Estoque", "Status"};
        modeloTabela = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };

        tabela = new JTable(modeloTabela);
        tabela.setFont(fontePadrao);
        tabela.setRowHeight(28); // Altura para leitura e clique
        tabela.getTableHeader().setFont(fonteNegrito);
        tabela.getTableHeader().setPreferredSize(new Dimension(0, 35));
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Alinhando colunas numéricas ao centro
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabela.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tabela.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tabela.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        sorter = new TableRowSorter<>(modeloTabela);
        tabela.setRowSorter(sorter);

        JScrollPane scrollTabela = new JScrollPane(tabela);
        add(scrollTabela, BorderLayout.CENTER);

        // 3. LATERAL DIREITA: AÇÕES DE CONTROLE
        JPanel painelAcoes = new JPanel(new GridLayout(6, 1, 0, 12));
        painelAcoes.setPreferredSize(new Dimension(220, 0));
        painelAcoes.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Ações de Estoque",
                0, 0, fonteNegrito));

        JButton btnAddEstoque = new JButton("Adicionar Estoque");
        JButton btnRemoverEstoque = new JButton("Remover Estoque");
        JButton btnAtualizar = new JButton("Editar Ingrediente");
        JButton btnExcluir = new JButton("Excluir Selecionado");
        JButton btnAlertaBaixo = new JButton("Alerta de Estoque");

        // Aplica fonte aos botões
        JButton[] botoes = {btnAddEstoque, btnRemoverEstoque, btnAtualizar, btnExcluir, btnAlertaBaixo};
        for (JButton b : botoes) {
            b.setFont(fontePadrao);
            b.setFocusPainted(false);
            painelAcoes.add(b);
        }
        btnExcluir.setForeground(new Color(220, 53, 69)); // Cor vermelha

        add(painelAcoes, BorderLayout.EAST);

        // Rodapé: Painel de Estatísticas
        JPanel painelRodape = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 8));
        painelRodape.setBorder(BorderFactory.createEtchedBorder());

        lblTotalTipos = new JLabel("Tipos Cadastrados: 0");
        lblEstoqueTotal = new JLabel("Volume Total no Estoque: 0");
        lblEsgotados = new JLabel("Itens Esgotados: 0");

        JLabel[] labelsRodape = {lblTotalTipos, lblEstoqueTotal, lblEsgotados};
        for (JLabel l : labelsRodape) {
            l.setFont(fonteNegrito);
            painelRodape.add(l);
        }
        lblEsgotados.setForeground(new Color(220, 53, 69));

        add(painelRodape, BorderLayout.SOUTH);

        // Listeners (ações ao selecionar algum botão)
        txtPesquisa.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) { filtrarTabela(); }
        });

        btnNovo.addActionListener(e -> cadastrarNovo());
        btnAddEstoque.addActionListener(e -> alterarEstoque(true));
        btnRemoverEstoque.addActionListener(e -> alterarEstoque(false));
        btnAtualizar.addActionListener(e -> atualizarSelecionado());
        btnExcluir.addActionListener(e -> excluirSelecionado());
        btnAlertaBaixo.addActionListener(e -> filtrarEstoqueBaixo());
    }

    //Métodos lógicos.
    private void atualizarTabela(List<Ingredientes> lista) {
        modeloTabela.setRowCount(0);
        int volTotal = 0;
        int qtdEsgotados = 0;

        for (Ingredientes ing : lista) {
            String status = ing.getEstoque() == 0 ? "ESGOTADO" : (ing.getEstoque() <= 10 ? "BAIXO" : "DISPONÍVEL");
            volTotal += ing.getEstoque();
            if (ing.getEstoque() == 0) qtdEsgotados++;

            modeloTabela.addRow(new Object[]{ ing.getId(), ing.getNome(), ing.getEstoque(), status });
        }

        lblTotalTipos.setText("Tipos Cadastrados: " + lista.size());
        lblEstoqueTotal.setText("Volume Total no Estoque: " + volTotal);
        lblEsgotados.setText("Itens Esgotados: " + qtdEsgotados);
    }

    private void filtrarTabela() {
        String busca = txtPesquisa.getText().trim();
        if (busca.isEmpty()) {
            sorter.setRowFilter(null);
            return;
        }
        int coluna = comboFiltro.getSelectedIndex(); // 0=Nome, 1=ID, 2=Status
        // Mapeia o ComboBox para as colunas reais da tabela (Nome=1, ID=0, Status=3)
        int colunaReal = (coluna == 0) ? 1 : (coluna == 1) ? 0 : 3;
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + busca, colunaReal));
    }

    private void cadastrarNovo() {
        JTextField txtNome = new JTextField();
        JTextField txtEstoque = new JTextField();
        Object[] form = {"Nome do Ingrediente:", txtNome, "Estoque Inicial:", txtEstoque};

        if (JOptionPane.showConfirmDialog(this, form, "Novo Cadastro", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            try {
                String nome = txtNome.getText().trim();
                int est = Integer.parseInt(txtEstoque.getText().trim());
                if (!nome.isEmpty()) {
                    controller.cadastrarIngrediente(new Ingredientes(nome, est));
                    atualizarTabela(controller.listarIngredientes());
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Estoque inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void alterarEstoque(boolean somar) {
        Integer id = obterIdSelecionado("alterar estoque");
        if (id == null) return;

        String input = JOptionPane.showInputDialog(this, somar ? "Quantidade a adicionar:" : "Quantidade a dar baixa:");
        if (input != null && !input.trim().isEmpty()) {
            try {
                int qtd = Integer.parseInt(input.trim());
                if (somar) controller.adicionarEstoque(id, qtd);
                else controller.removerEstoque(id, qtd);
                atualizarTabela(controller.listarIngredientes());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Digite um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void atualizarSelecionado() {
        Integer id = obterIdSelecionado("editar");
        if (id == null) return;

        Ingredientes ing = controller.buscarId(id);
        if (ing == null) return;

        JTextField txtNome = new JTextField(ing.getNome());
        JTextField txtEstoque = new JTextField(String.valueOf(ing.getEstoque()));
        Object[] form = {"Nome:", txtNome, "Estoque:", txtEstoque};

        if (JOptionPane.showConfirmDialog(this, form, "Editar ID: " + id, JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            try {
                controller.atualizarIngrediente(id, new Ingredientes(txtNome.getText().trim(), Integer.parseInt(txtEstoque.getText().trim())));
                atualizarTabela(controller.listarIngredientes());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Valores inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void excluirSelecionado() {
        Integer id = obterIdSelecionado("excluir");
        if (id == null) return;

        if (JOptionPane.showConfirmDialog(this, "Confirma exclusão do ID " + id + "?", "Excluir", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            controller.excluirIngrediente(id);
            atualizarTabela(controller.listarIngredientes());
        }
    }

    private void filtrarEstoqueBaixo() {
        String input = JOptionPane.showInputDialog(this, "Filtrar estoque menor ou igual a:", "10");
        if (input != null) {
            try {
                atualizarTabela(controller.listarEstoqueBaixo(Integer.parseInt(input.trim())));
                // Adiciona um botão para limpar o filtro e voltar a ver tudo
                JButton btnLimpar = new JButton("Limpar Filtro de Alerta");
                btnLimpar.addActionListener(e -> {
                    atualizarTabela(controller.listarIngredientes());
                    ((JPanel)getContentPane()).remove(btnLimpar);
                    revalidate();
                    repaint();
                });
                add(btnLimpar, BorderLayout.NORTH);
                revalidate();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Número inválido.");
            }
        }
    }

    private Integer obterIdSelecionado(String acao) {
        int linha = tabela.getSelectedRow();
        if (linha != -1) {
            // Pega o ID da linha visual correta, mesmo se a tabela estiver ordenada/filtrada
            return (Integer) tabela.getValueAt(linha, 0);
        } else {
            String in = JOptionPane.showInputDialog(this, "Nenhum item selecionado na tabela.\nDigite o ID para " + acao + ":");
            try {
                return (in != null && !in.trim().isEmpty()) ? Integer.parseInt(in.trim()) : null;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID Inválido.");
                return null;
            }
        }
    }
}
