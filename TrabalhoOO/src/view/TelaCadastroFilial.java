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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.ControleFilial;

public class TelaCadastroFilial {
	private JFrame frame;

    public void initialize() {
        frame = new JFrame();
        frame.setTitle("Cadastro de filial");
        frame.setSize(600, 300);
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
        
        JPanel painelDados = new JPanel(new GridLayout(2, 1, 10, 10));
        painelDados.setBorder(BorderFactory.createEmptyBorder(15, 15, 120, 40));
        painelDados.setAlignmentX(Component.TOP_ALIGNMENT);
        JLabel labelCidade = new JLabel("CIDADE: ");
        JTextField txtCidade = new JTextField(30);
        txtCidade.setBounds(100,100,100,100);
        
        JLabel labelEndereco = new JLabel("ENDEREÇO: ");
        JTextField txtEndereco = new JTextField(50);
        
        painelDados.add(labelCidade);
        painelDados.add(txtCidade);
        painelDados.add(labelEndereco);
        painelDados.add(txtEndereco);
        
        
        
        JPanel panelBotoes = new JPanel(new GridLayout(1, 5, 10, 10));
        panelBotoes.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelBotoes.setAlignmentX(Component.BOTTOM_ALIGNMENT);

        JButton bAdd = new JButton("Salvar");
        bAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cidade = txtCidade.getText();
                String endereco = txtEndereco.getText();
                boolean sucesso;
                try {
                	ControleFilial controle = new ControleFilial();
                	sucesso = controle.salvarFilial(cidade, endereco);
                	if (sucesso) {
                		JOptionPane.showMessageDialog(null, "A filial foi cadastrada"
                				+ " com sucesso!");
                	} else {
                		JOptionPane.showMessageDialog(null, "Os campos não foram "
                				+ "preenchidos corretamente.");
                	}
                	
                } catch (Exception e2) {
                	JOptionPane.showMessageDialog(null, "Erro: " + e2);
                }
            }
        });

        JButton bRemove = new JButton("Limpar");
        bRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	txtCidade.setText("");
                txtEndereco.setText("");
            }
        });
        
        JButton bUpdate = new JButton("Cancelar");
        bUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        JButton bRead = new JButton("Consultar");
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
        
        frame.add(painelDados, BorderLayout.CENTER);
        frame.add(panelBotoes, BorderLayout.SOUTH);
        
        frame.setVisible(true);
    }
    
    private void voltar() {
    	frame.dispose();
    	TelaAdministracao v = new TelaAdministracao();
    	v.initialize();
    }
    
}