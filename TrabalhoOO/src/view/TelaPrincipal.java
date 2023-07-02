package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

import controller.ControleCliente;
import controller.ControleFilial;
import controller.ControleProduto;

public class TelaPrincipal{

    private JFrame frame;

    public TelaPrincipal(ControleCliente cc, ControleFilial cf, ControleProduto cp) {
        frame = new JFrame();
        frame.setTitle("Bem-vindo");
        frame.setSize(600, 320);
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
        lblTitulo.setFont(new Font("SansSerif", Font.ITALIC, 20));
        panelTitulo.add(lblTitulo);
          
        
        JPanel panelBotoes = new JPanel(new GridLayout(2, 1, 10, 10));
        panelBotoes.setBorder(BorderFactory.createEmptyBorder(20, 110, 20, 110));
        panelBotoes.setAlignmentX(Component.BOTTOM_ALIGNMENT);

        JButton btnAdministracao = new JButton("Administração");
        btnAdministracao.setFocusable(false);
        btnAdministracao.setFont(new Font("SansSerif", Font.PLAIN, 17));
        btnAdministracao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new TelaLoginAdministracao(cc,cf,cp);
            }
        });

        JButton btnCliente = new JButton("Cliente");
        btnCliente.setFocusable(false);
        btnCliente.setFont(new Font("SansSerif", Font.PLAIN, 17));
        btnCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new TelaLoginCliente();
            }
        });

        panelBotoes.add(btnAdministracao);
        panelBotoes.add(btnCliente);

        frame.add(panelTitulo, BorderLayout.NORTH);
        frame.add(panelBotoes, BorderLayout.CENTER);

        frame.setVisible(true);
    }

}