package com.github.Gregorys2s.view.login;

import com.github.Gregorys2s.model.service.login.LoginService;
import com.github.Gregorys2s.model.service.login.UsuarioLogado;
import com.github.Gregorys2s.model.service.login.Impl.LoginServiceImpl;
import com.github.Gregorys2s.view.tema.TemaSistema;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

public class LoginView extends JFrame {

    private final LoginService loginService = new LoginServiceImpl();

    private final Runnable aoLogar;

    private JTextField usuarioField;
    private JPasswordField senhaField;
    private JButton entrarButton;

    public LoginView(Runnable aoLogar) {
        this.aoLogar = aoLogar;

        setTitle("Login - Lanchonete");
        setSize(460, 460);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        montarTela();
        configurarEnter();

        SwingUtilities.invokeLater(() -> usuarioField.requestFocusInWindow());
    }

    private void montarTela() {

        JPanel fundo = new JPanel(new GridBagLayout());
        fundo.setBackground(TemaSistema.fundo());

        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(TemaSistema.card());
        card.setBorder(BorderFactory.createEmptyBorder(32, 32, 32, 32));
        card.setPreferredSize(new Dimension(340, 340));

        JLabel titulo = new JLabel("Lanchonete");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 30));
        titulo.setForeground(TemaSistema.primaria());
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitulo = new JLabel("Acesse o sistema");
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        subtitulo.setForeground(TemaSistema.textoSecundario());
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usuarioLabel = criarLabel("Usuário");

        usuarioField = new JTextField();
        usuarioField.setMaximumSize(new Dimension(260, 42));
        usuarioField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel senhaLabel = criarLabel("Senha");

        senhaField = new JPasswordField();
        senhaField.setMaximumSize(new Dimension(260, 42));
        senhaField.setAlignmentX(Component.CENTER_ALIGNMENT);

        entrarButton = new JButton("Entrar");
        entrarButton.setMaximumSize(new Dimension(260, 44));
        entrarButton.setPreferredSize(new Dimension(260, 44));
        entrarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        entrarButton.addActionListener(e -> tentarLogin());

        card.add(titulo);
        card.add(Box.createVerticalStrut(6));
        card.add(subtitulo);
        card.add(Box.createVerticalStrut(28));

        card.add(usuarioLabel);
        card.add(Box.createVerticalStrut(6));
        card.add(usuarioField);
        card.add(Box.createVerticalStrut(16));

        card.add(senhaLabel);
        card.add(Box.createVerticalStrut(6));
        card.add(senhaField);
        card.add(Box.createVerticalStrut(24));

        card.add(entrarButton);

        fundo.add(card);

        setContentPane(fundo);

        TemaSistema.aplicar(this);

        titulo.setForeground(TemaSistema.primaria());
        subtitulo.setForeground(TemaSistema.textoSecundario());
    }

    private JLabel criarLabel(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label.setForeground(TemaSistema.texto());
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    private void configurarEnter() {
        usuarioField.addActionListener(e -> {
            senhaField.requestFocusInWindow();
            senhaField.selectAll();
        });

        senhaField.addActionListener(e -> entrarButton.doClick());

        getRootPane().setDefaultButton(entrarButton);
    }

    private void tentarLogin() {

        String usuario = usuarioField.getText().trim();

        String senha = new String(senhaField.getPassword());

        Optional<UsuarioLogado> usuarioLogado =
                loginService.autenticarUsuario(usuario, senha);

        if (usuarioLogado.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Usuário ou senha inválidos.\n\n" +
                            "Usuários permitidos:\n" +
                            "- atendente\n" +
                            "- gerente",
                    "Erro de login",
                    JOptionPane.ERROR_MESSAGE
            );

            senhaField.setText("");
            usuarioField.requestFocusInWindow();
            usuarioField.selectAll();

            return;
        }

        dispose();

        if (aoLogar != null) {
            aoLogar.run();
        }
    }
}