package view;

import javax.swing.*;

import controller.ControleCliente;
import controller.ControleFilial;
import controller.ControleProduto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TelaLoginAdministracao{

    private JFrame frame;
    private JTextField txtUsuario;
    private JPasswordField txtSenha;

    public TelaLoginAdministracao(ControleCliente cc, ControleFilial cf, ControleProduto cp) {
        frame = new JFrame();
        frame.setTitle("Login");
        frame.setSize(300, 200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = frame.getWidth();
        int frameHeight = frame.getHeight();
        int xPos = (screenWidth - frameWidth) / 2;
        int yPos = (screenHeight - frameHeight) / 2;
        frame.setLocation(xPos, yPos);

        JPanel panelTitulo = new JPanel();
        
        JPanel panelFormulario = new JPanel(new GridLayout(2, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblUsuario = new JLabel("Usuário:");
        txtUsuario = new JTextField(10);
        txtUsuario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent usuarioTxt) {
                if (usuarioTxt.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtSenha.requestFocus();
                }
            }
        });

        JLabel lblSenha = new JLabel("Senha:");
        txtSenha = new JPasswordField(10);
        txtSenha.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent SenhaTxt) {
                if (SenhaTxt.getKeyCode() == KeyEvent.VK_ENTER) {
                	realizarLogin(cc,cf,cp);
                }
            }
        });
        
        panelFormulario.add(lblUsuario);
        panelFormulario.add(txtUsuario);
        panelFormulario.add(lblSenha);
        panelFormulario.add(txtSenha);
        

        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnLogin = new JButton("Login");
        btnLogin.setFocusable(false);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	realizarLogin(cc,cf,cp);
            }
        });
        JButton voltar = new JButton("Voltar");
        voltar.setFocusable(false);
        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            }
        });
        
        panelBotoes.add(btnLogin);
        panelBotoes.add(voltar);
        
        frame.add(panelTitulo, BorderLayout.NORTH);
        frame.add(panelFormulario, BorderLayout.CENTER);
        frame.add(panelBotoes, BorderLayout.SOUTH);

        frame.setVisible(true);
        
    }
    
    private void realizarLogin(ControleCliente cc,ControleFilial cf, ControleProduto cp) {
        String usuario = txtUsuario.getText();
        String senha = new String(txtSenha.getPassword());

        if (usuario.equals("fga") && senha.equals("123")) {
            frame.dispose();
            new TelaAdministracao(cc,cf,cp);
        } else {
            JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos. Tente novamente.", "Erro de autenticação", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
