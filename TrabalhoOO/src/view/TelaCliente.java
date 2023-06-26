package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controller.ControleCliente;

public class TelaCliente extends JFrame{
	ControleCliente cc = new ControleCliente();
	JTable table;
	
	JTextField t1,t2,t3;
	JButton b1, b2, b3;
	
	 public TelaCliente(){
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		Object[] nomeColunas = {"Nome", "CPF", "Idade"};
		DefaultTableModel modelo = new DefaultTableModel(nomeColunas, 0);
		table = new JTable(modelo);
		
		setLayout(new GridLayout(3, 3));
		JPanel painelC = new JPanel();
		add(new JScrollPane(table));
		add(new JPanel());
		add(painelC);
		
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		
		b1 = new JButton("Salvar");
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(t1.getText().toString().isEmpty() || t2.getText().toString().isEmpty() || t3.getText().toString().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor preencha os campos corretamente.", "Erro: ", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else {
					
					cc.salvarCliente(t1.getText(), t2.getText(), t3.getText());

					modelo.addRow(cc.lerCliente());
					
					t1.setText(getName());
					t2.setText(getName());
					t3.setText(getName());
					
					JOptionPane.showMessageDialog(null, "Cadastro de cliente realizado com sucesso!");					
				}
			}
		});
		b2 = new JButton("Atualizar");
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
					modelo.setValueAt(nome, linha, 0);
					modelo.setValueAt(cpf, linha, 1);
					modelo.setValueAt(idade, linha, 2);
					
					t1.setText(null);
					t2.setText(null);
					t3.setText(null);
				}
				
			}
		});
		//Botão de remover e função para o botão
		b3 = new JButton("Remover");
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
						cc.removerCliente(table.getSelectedRow());
						modelo.removeRow(table.getSelectedRow());
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
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linhaIndex = table.getSelectedRow();
				String nome = (String) modelo.getValueAt(linhaIndex, 0);
				String cpf = (String) modelo.getValueAt(linhaIndex, 1);
				int idade = (int) modelo.getValueAt(linhaIndex, 2);
				
				t1.setText(nome);
				t2.setText(cpf);
				t3.setText(String.valueOf(idade));
				
			}
		});
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //Define que apenas uma linha pode ser escolhida!	
	}
	 
}