package view;

import javax.swing.*;

import controller.ControleCliente;
import controller.ControleFilial;
import controller.ControleProduto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAdministracao {

    private JFrame frame;

    public TelaAdministracao(ControleCliente cc, ControleFilial cf, ControleProduto cp) {
        frame = new JFrame();
        frame.setTitle("Administração");
        frame.setSize(700, 600);
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

        JPanel panelBotoes = new JPanel(new GridLayout(4, 1, 10, 10));
        panelBotoes.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
        
        JButton btnClientes = new JButton("Clientes");
        btnClientes.setFont(new Font("SansSerif", Font.PLAIN, 17));
        btnClientes.setFocusable(false);
        btnClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new TelaCliente(cc);
            }
        });

        JButton btnFiliais = new JButton("Filiais");
        btnFiliais.setFont(new Font("SansSerif", Font.PLAIN, 17));
        btnFiliais.setFocusable(false);
        btnFiliais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new TelaFilial(cf);
            }
        });

        JButton btnProdutos = new JButton("Produtos");
        btnProdutos.setFont(new Font("SansSerif", Font.PLAIN, 17));
        btnProdutos.setFocusable(false);
        btnProdutos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new TelaProduto(cp);
            }
        });
        
        JButton back = new JButton("Voltar");
        back.setFont(new Font("SansSerif", Font.PLAIN, 17));
        back.setFocusable(false);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltar();
            }
        });
        
        panelBotoes.add(btnClientes);
        panelBotoes.add(btnFiliais);
        panelBotoes.add(btnProdutos);
        panelBotoes.add(back);
        frame.add(panelBotoes, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void voltar() {
    	frame.dispose();
    }
}