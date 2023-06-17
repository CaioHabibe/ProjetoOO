package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAdministracao {

    private JFrame frame;

    public void initialize() {
        frame = new JFrame();
        frame.setTitle("Administração");
        frame.setSize(300, 200);
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

        JPanel panelBotoes = new JPanel(new GridLayout(4, 1, 10, 10));
        panelBotoes.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnClientes = new JButton("Clientes");
        btnClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaClientes();
            }
        });

        JButton btnFiliais = new JButton("Filiais");
        btnFiliais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaFiliais();
            }
        });

        JButton btnProdutos = new JButton("Produtos");
        btnProdutos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaProdutos();
            }
        });
        
        JButton back = new JButton("Voltar");
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

    private void abrirTelaClientes() {
        frame.dispose();
        TelaGerenciamentoCliente tela = new TelaGerenciamentoCliente();
        tela.initialize();
    }

    private void abrirTelaFiliais() {
        frame.dispose();
        TelaGerenciamentoFilial telaFilial = new TelaGerenciamentoFilial();
        telaFilial.initialize();
    }

    private void abrirTelaProdutos() {
        frame.dispose();
        TelaGerenciamentoProduto t = new TelaGerenciamentoProduto();
        t.initialize();
    }
    
    private void voltar() {
    	frame.dispose();
    	TelaBoasVindas v = new TelaBoasVindas();
    	v.initialize();
    }
}