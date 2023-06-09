package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ControleCliente;

public class TelaCadastroCliente {
	private JFrame frame;
    private JTextField txtUsuario;
    private JTextField txtCPF;
    private JTextField txtIdade;

    public TelaCadastroCliente(ControleCliente cc) {
        frame = new JFrame();
        frame.setTitle("Cadastro de cliente");
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
        
        JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblUsuario = new JLabel("Nome do Usuário:");
        txtUsuario = new JTextField(10);
        txtUsuario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent usuarioTxt) {
                if (usuarioTxt.getKeyCode() == KeyEvent.VK_ENTER) {
                	txtCPF.requestFocus();
                }
            }
        });

        JLabel lblCPF = new JLabel("CPF do Usuário:");
        txtCPF = new JTextField(10);
        txtCPF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent SenhaTxt) {
                if (SenhaTxt.getKeyCode() == KeyEvent.VK_ENTER) {
                	txtIdade.requestFocus();
                }
            }
        });
        
        JLabel lblIdade = new JLabel("Idade do Usuário:");
        txtIdade = new JTextField(10);
        txtIdade.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent SenhaTxt) {
                if (SenhaTxt.getKeyCode() == KeyEvent.VK_ENTER) {
                	cadastrar(cc);
                }
            }
        });
        
        
        panelFormulario.add(lblUsuario);
        panelFormulario.add(txtUsuario);
        panelFormulario.add(lblCPF);
        panelFormulario.add(txtCPF);
        panelFormulario.add(lblIdade);
        panelFormulario.add(txtIdade);
        

        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnLogin = new JButton("Salvar");
        btnLogin.setFocusable(false);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	cadastrar(cc);
            }
        });
        
        panelBotoes.add(btnLogin);
        
        frame.add(panelTitulo, BorderLayout.NORTH);
        frame.add(panelFormulario, BorderLayout.CENTER);
        frame.add(panelBotoes, BorderLayout.SOUTH);

        frame.setVisible(true);     
    }
    
    public void cadastrar(ControleCliente cc) {
    	cc.salvarCliente(txtUsuario.getText(), Long.valueOf(txtCPF.getText()), Integer.valueOf(txtIdade.getText()));
    	frame.dispose();
    }
    
}
