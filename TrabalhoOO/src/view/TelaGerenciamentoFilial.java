package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaGerenciamentoFilial {
	private JFrame frame;

    public void initialize() {
        frame = new JFrame();
        frame.setTitle("Bem-vindo");
        frame.setSize(800, 600);
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
        
        JPanel panelBotoes = new JPanel(new GridLayout(5, 1, 10, 10));
        panelBotoes.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelBotoes.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton bAdd = new JButton("Adicionar filial");
        bAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        JButton bRemove = new JButton("Remover filial");
        bRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        JButton bUpdate = new JButton("Atualizar filial");
        bUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        JButton bRead = new JButton("Mostrar filial");
        bRead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        JButton back = new JButton("Voltar");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltar();
            }
        });
        
        panelBotoes.add(bAdd);
        panelBotoes.add(bRemove);
        panelBotoes.add(bUpdate);
        panelBotoes.add(bRead);
        panelBotoes.add(back);
        
        frame.add(panelBotoes, BorderLayout.CENTER);

        frame.setVisible(true);
    }
    
    private void voltar() {
    	frame.dispose();
    	TelaAdministracao v = new TelaAdministracao();
    	v.initialize();
    }
    
}