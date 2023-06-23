package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal {

    private JFrame frame;

    public void initialize() {
        frame = new JFrame();
        frame.setTitle("Bem-vindo");
        frame.setSize(400, 300);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        JLabel lblTitulo = new JLabel("Bem-vindo à farmaFGA");
        panelTitulo.add(lblTitulo);
          
        
        JPanel panelBotoes = new JPanel(new GridLayout(2, 1, 10, 10));
        panelBotoes.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        panelBotoes.setAlignmentX(Component.BOTTOM_ALIGNMENT);

        JButton btnAdministracao = new JButton("Administração");
        btnAdministracao.setFocusable(false);
        btnAdministracao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaLoginAdmin();
            }
        });

        JButton btnCliente = new JButton("Cliente");
        btnCliente.setFocusable(false);
        btnCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCarrinho();
            }
        });

        panelBotoes.add(btnAdministracao);
        panelBotoes.add(btnCliente);

        frame.add(panelTitulo, BorderLayout.NORTH);
        frame.add(panelBotoes, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void abrirTelaCarrinho() {
    	frame.dispose();
    	TelaCarrinho t = new TelaCarrinho();
    	t.initialize();
    }
    
    private void abrirTelaLoginAdmin() {
        frame.dispose();
        TelaLoginAdministracao telaLogin = new TelaLoginAdministracao();
        telaLogin.initialize();
    }
    
    public static void main(String[] args) {
		try {
			TelaPrincipal telaBoasVindas = new TelaPrincipal();
	        telaBoasVindas.initialize();
		} catch (Exception e) {
			System.out.println("Houve um problema na inicialização "
					+ "da tela.");
		}
		
    }
}