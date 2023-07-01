package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.ControleCliente;

public class TelaCliente extends JFrame{
	
	private JTable table;
	
	private JTextField t1,t2,t3;
	private JButton b1, b2, b3;
	
	private DefaultListModel dlm = new DefaultListModel();
	JList lista = new JList();
	 
	 public TelaCliente(ControleCliente cc){
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = getWidth();
        int frameHeight = getHeight();
        int xPos = (screenWidth - frameWidth) / 2;
        int yPos = (screenHeight - frameHeight) / 2;
        setLocation(xPos, yPos);
        
        lista.setModel(dlm);
        
		setLayout(new GridLayout(3, 3));
		JPanel painelC = new JPanel();
		painelC.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 20));
		add(new JScrollPane(lista));
		add(new JPanel());
		add(painelC);
		
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();

		b1 = new JButton("Salvar");
		b1.setFont(new Font("SansSerif", Font.PLAIN, 17));
		b1.setFocusable(false);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(t1.getText().toString().isEmpty() || t2.getText().toString().isEmpty() || t3.getText().toString().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor preencha os campos corretamente.", "Erro: ", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else {
					
					cc.salvarCliente(t1.getText(), t2.getText(), t3.getText());
					
//					Object [] dados = cc.lerCliente();
//					
//				      for (int i = 0; i < dados.length; i++) {
//				    	  dlm.addElement(dados[i]);
//				      }
					
					t1.setText(null);
					t2.setText(null);
					t3.setText(null);
					
					JOptionPane.showMessageDialog(null, "Cadastro de cliente realizado com sucesso!");					
				}
			}
		});
		b2 = new JButton("Atualizar");
		b2.setFont(new Font("SansSerif", Font.PLAIN, 17));
		b2.setFocusable(false);
		b2.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(t1.getText().toString().isEmpty() || t2.getText().toString().isEmpty() || t3.getText().toString().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor preencha os campos corretamente.", "Erro: ", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else {
					String nome = t1.getText().toString();
					String cpf =  t2.getText().toString();
					int idade = Integer.parseInt(t3.getText().toString());
					
//					cc.atualizarCliente(nome, cpf, idade);
					
					int linha = table.getSelectedRow();
					
					t1.setText(null);
					t2.setText(null);
					t3.setText(null);
				}
				
			}
		});
		//Botão de remover e função para o botão
		b3 = new JButton("Remover");
		b3.setFont(new Font("SansSerif", Font.PLAIN, 17));
		b3.setFocusable(false);
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Por favor, selecione uma linha.", "Erro: ", JOptionPane.ERROR_MESSAGE);
				}
				else {
					int escolha = JOptionPane.showConfirmDialog(null, "Você realmente deseja apagar esta linha? \n" + 
																"NOME: " + t1.getText() + "\n"
															  + "CPF: " + t2.getText() + "\n"
															  + "IDADE: " + t3.getText(), "Confirm", JOptionPane.YES_NO_OPTION);
					
					if (escolha == JOptionPane.YES_OPTION) {
					}
				}
			}
		});	
		painelC.setLayout(new GridLayout(3, 3));
		
		painelC.add(new JLabel("Nome:"));
		painelC.add(t1);
		painelC.add(b1);
		
		painelC.add(new JLabel("CPF:"));
		painelC.add(t2);
		painelC.add(b2);
		
		painelC.add(new JLabel("Idade:"));
		painelC.add(t3);
		painelC.add(b3);
		
		validate();
	}
	 
}