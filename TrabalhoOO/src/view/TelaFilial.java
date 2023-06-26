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

import controller.ControleFilial;

public class TelaFilial extends JFrame{
	JTable table;
	
	JTextField t1,t2,t3;
	JButton b1, b2, b3;
	
	TelaFilial(){
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		String[][] dataC = { 
				
		};
		
		String[] nomeColunas = {"Cidade", "Endereço", "CNPJ"};
		
		DefaultTableModel modelo = new DefaultTableModel(dataC, nomeColunas);
		
		table = new JTable(modelo);
		
		setLayout(new GridLayout(3, 3));
		JPanel painelC = new JPanel();
		add(new JScrollPane(table));
		add(new JPanel());
		add(painelC);
		
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		
		b1 = new JButton("Add");
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(t1.getText().toString().isEmpty() || t2.getText().toString().isEmpty() || t3.getText().toString().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor preencha os campos corretamente.", "Erro: ", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else {
					String cidade = t1.getText();
					String endereco =  t2.getText();
					String cnpj = t3.getText();
					
					ControleFilial cf = new ControleFilial();
					cf.salvarFilial(cidade, endereco, cnpj);
					
					String[] novaLinha = {cf.ler()};
					modelo.addRow(novaLinha);
					t1.setText(null);
					t2.setText(null);
					t3.setText(null);
				}
				
			}
		});
		
		b2 = new JButton("Update");
		b2.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(t1.getText().toString().isEmpty() || t2.getText().toString().isEmpty() || t3.getText().toString().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor preencha os campos corretamente.", "Erro: ", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else {
					String cidade = t1.getText().toString();
					String endereco =  t2.getText().toString();
					String cnpj = t3.getText().toString();
					
					int linha = table.getSelectedRow();
					modelo.setValueAt(cidade, linha, 0);
					modelo.setValueAt(endereco, linha, 1);
					modelo.setValueAt(cnpj, linha, 2);
					
					t1.setText(null);
					t2.setText(null);
					t3.setText(null);
				}
				
			}
		});
		
		//Botão de remover e função para o botão
		b3 = new JButton("Delete");
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Por favor, selecione uma linha.", "Erro: ", JOptionPane.ERROR_MESSAGE);
				}
				else {
					int escolha = JOptionPane.showConfirmDialog(null, "Você realmente deseja apagar esta linha? ", "Confirm", JOptionPane.YES_NO_OPTION);
					
					if (escolha == JOptionPane.YES_OPTION) {
						modelo.removeRow(table.getSelectedRow());
					}
				}
				
				
			}
		});
		
		
		
		
		painelC.setLayout(new GridLayout(3, 3));
		
		painelC.add(new JLabel("Cidade:"));
		painelC.add(t1);
		painelC.add(b1);
		
		painelC.add(new JLabel("Endereço:"));
		painelC.add(t2);
		painelC.add(b2);
		
		painelC.add(new JLabel("CNPJ:"));
		painelC.add(t3);
		painelC.add(b3);
		
		validate();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linhaIndex = table.getSelectedRow();
				String cidade = (String) modelo.getValueAt(linhaIndex, 0);
				String endereco = (String) modelo.getValueAt(linhaIndex, 1);
				String cnpj = (String) modelo.getValueAt(linhaIndex, 2);
				
				t1.setText(cidade);
				t2.setText(endereco);
				t3.setText(cnpj);
				
			}
		});
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //Define que apenas uma linha pode ser escolhida!
		
		
		
		
		
		
	}
}
