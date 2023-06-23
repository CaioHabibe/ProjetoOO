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

import controller.ControleProduto;

public class TelaCadastroProduto {
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
        
        JPanel painelDados = new JPanel(new GridLayout(8, 1, 10, 10));
        painelDados.setBorder(BorderFactory.createEmptyBorder(15, 15, 120, 40));
        painelDados.setAlignmentX(Component.TOP_ALIGNMENT);
        
        JLabel labelTipo = new JLabel("Tipo de produto: ");
        JTextField txtTipo = new JTextField(16);
        
        JLabel labelNome = new JLabel("Nome: ");
        JTextField txtNome = new JTextField(50);
        txtNome.setBounds(100,100,100,100);
        
        JLabel labelPreco = new JLabel("Preço: ");
        JTextField txtPreco = new JTextField(11);
        
        JLabel labelDescricao= new JLabel("Descrição: ");
        JTextField txtDescricao = new JTextField(11);
        txtNome.setBounds(100,100,100,100);
        
        JLabel labelId = new JLabel("ID: ");
        JTextField txtId = new JTextField(11);
        
        JLabel labelPrimaria = new JLabel("Dosagem (Remedio)/Textura (Cosmetico)");
        JTextField txtPrimaria = new JTextField(20);
       
        JLabel labelSecundaria = new JLabel("Formula (Remedio)/ Fragrância (Cosmetico)");   
        JTextField txtSecundaria = new JTextField(50);
        
        JLabel labelTerciaria = new JLabel("Administração (Remedio)/ Corante (Cosmetico)");
        JTextField txtTerciaria = new JTextField(30);
        
        painelDados.add(labelTipo);
        painelDados.add(txtTipo);
        painelDados.add(labelNome);
        painelDados.add(txtNome);
        painelDados.add(labelPreco);
        painelDados.add(txtPreco);
        painelDados.add(labelDescricao);
        painelDados.add(txtDescricao);
        painelDados.add(labelId);
        painelDados.add(txtId);
        painelDados.add(labelPrimaria);
        painelDados.add(txtPrimaria);
        painelDados.add(labelSecundaria);
        painelDados.add(txtSecundaria);
        painelDados.add(labelTerciaria);
        painelDados.add(txtTerciaria);
        
        JPanel panelBotoes = new JPanel(new GridLayout(1, 5, 10, 10));
        panelBotoes.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelBotoes.setAlignmentX(Component.BOTTOM_ALIGNMENT);

        JButton bAdd = new JButton("Salvar");
        bAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//            	String tipo = txtTipo.getText();
//                String nome = txtNome.getText();
//                double preco = Double.parseDouble(txtPreco.getText());
//                String descricao = txtDescricao.getText();
//                long id = Integer.parseInt(txtId.getText());
//                boolean sucesso;
//                try {
//                	 ControleProduto controle = new ControleProduto();
//                	 sucesso = controle.salvarProduto(tipo, nome, preco, descricao, id);
//                	 
//                	 
//                } catch (Exception e2) {
//                	JOptionPane.showMessageDialog(null, "Erro: " + e2);
//                }
            }
        });

        JButton bRemove = new JButton("Limpar");
        bRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTipo.setText("");
                txtNome.setText("");
                txtPreco.setText("");
                txtDescricao.setText("");
                txtId.setText("");
                txtPrimaria.setText("");
                txtSecundaria.setText("");
                txtTerciaria.setText("");
                
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
                consultar();
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
        
        frame.add(painelDados, BorderLayout.NORTH);
        frame.add(panelBotoes, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
    
    private void voltar() {
    	frame.dispose();
    	TelaAdministracao v = new TelaAdministracao();
    	v.initialize();
    }
    
    private void consultar() {
    	frame.dispose();
    	TelaConsultaProduto v = new TelaConsultaProduto();
    	v.initialize();
    }
}