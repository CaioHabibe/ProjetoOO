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

public class TelaProduto extends JFrame{
	JTable table;
	
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JButton b1, b2, b3;
	
	TelaProduto(){
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		String[][] dataC = { 
				{"Remedio", "Dipirona", "30,00", "Antipirético", "#0001", "30mg", "Metanidol", "Oral"}
		};
		
		String[] nomeColunas = {"Tipo", "Nome", "Preço", "Descrição", "Id", "Dosagem/Textura", "Fórmula/Fragrância", "Administração/Corante"};
		
		DefaultTableModel modelo = new DefaultTableModel(dataC, nomeColunas);
		
		table = new JTable(modelo);
		
		setLayout(new GridLayout(3, 8));
		JPanel painelC = new JPanel();
		add(new JScrollPane(table));
		add(new JPanel());
		add(painelC);
		
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();
		t6 = new JTextField();
		t7 = new JTextField();
		t8 = new JTextField();
		
		b1 = new JButton("Add");
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				if(t1.getText().toString().isEmpty() || t2.getText().toString().isEmpty() || t3.getText().toString().isEmpty()
						|| t4.getText().toString().isEmpty() || t5.getText().toString().isEmpty() || t6.getText().toString().isEmpty()
						|| t7.getText().toString().isEmpty() || t8.getText().toString().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor preencha os campos corretamente.", "Erro: ", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else {
					String tipo = t1.getText().toString();
					String nome =  t2.getText().toString();
					double preco = Double.parseDouble(t3.getText().toString());
					String descricao = t4.getText().toString();
					String id = t5.getText().toString();
					String dostex = t6.getText().toString();
					String forfra = t7.getText().toString();
					String admcor = t8.getText().toString();
					
					Object[] novaLinha = {tipo, nome, preco, descricao, id, dostex, forfra, admcor};
					modelo.addRow(novaLinha);
					t1.setText(null);
					t2.setText(null);
					t3.setText(null);
					t4.setText(null);
					t5.setText(null);
					t6.setText(null);
					t7.setText(null);
					t8.setText(null);
				}
			}
		});
		
		b2 = new JButton("Update");
		b2.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(t1.getText().toString().isEmpty() || t2.getText().toString().isEmpty() || t3.getText().toString().isEmpty()
						|| t4.getText().toString().isEmpty() || t5.getText().toString().isEmpty() || t6.getText().toString().isEmpty()
						|| t7.getText().toString().isEmpty() || t8.getText().toString().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor preencha os campos corretamente.", "Erro: ", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else {
					String tipo = t1.getText().toString();
					String nome =  t2.getText().toString();
					double preco = Double.parseDouble(t3.getText().toString());
					String descricao = t4.getText().toString();
					String id = t5.getText().toString();
					String dostex = t6.getText().toString();
					String forfra = t7.getText().toString();
					String admcor = t8.getText().toString();

					int linha = table.getSelectedRow();
					modelo.setValueAt(tipo, linha, 0);
					modelo.setValueAt(nome, linha, 1);
					modelo.setValueAt(preco, linha, 2);
					modelo.setValueAt(descricao, linha, 3);
					modelo.setValueAt(id, linha, 4);
					modelo.setValueAt(dostex, linha, 5);
					modelo.setValueAt(forfra, linha, 6);
					modelo.setValueAt(admcor, linha, 7);

					t1.setText(null);
					t2.setText(null);
					t3.setText(null);
					t4.setText(null);
					t5.setText(null);
					t6.setText(null);
					t7.setText(null);
					t8.setText(null);
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
		painelC.setLayout(new GridLayout(9, 2));
		
		painelC.add(new JLabel("Tipo:"));
		painelC.add(t1);
		//painelC.add(b1);
		
		painelC.add(new JLabel("Nome:"));
		painelC.add(t2);
		//painelC.add(b2);
		
		painelC.add(new JLabel("Preço:"));
		painelC.add(t3);
		//painelC.add(b3);
		
		painelC.add(new JLabel("Descrição"));
		painelC.add(t4);
		
		
		painelC.add(new JLabel("Id"));
		painelC.add(t5);
		
		
		painelC.add(new JLabel("Dosagem/Textura"));
		painelC.add(t6);
		
		
		painelC.add(new JLabel("Fórmula/Fragrância"));
		painelC.add(t7);
		
		
		painelC.add(new JLabel("Administração/Corante"));
		painelC.add(t8);
		
		JPanel painelBotoes = new JPanel(new GridLayout(1, 3));
		painelBotoes.add(b1);
		painelBotoes.add(b2);
		painelBotoes.add(b3);
		
		painelC.add(painelBotoes);
		
		validate();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linhaIndex = table.getSelectedRow();
				String tipo = (String) modelo.getValueAt(linhaIndex, 0);
				String nome = (String) modelo.getValueAt(linhaIndex, 1);
				String preco = (String) modelo.getValueAt(linhaIndex, 2);
				String descricao = (String) modelo.getValueAt(linhaIndex, 3);
				String id = (String) modelo.getValueAt(linhaIndex, 4);
				String dostex = (String) modelo.getValueAt(linhaIndex, 5);
				String forfra = (String) modelo.getValueAt(linhaIndex, 6);
				String admcor = (String) modelo.getValueAt(linhaIndex, 7);
				
				t1.setText(tipo);
				t2.setText(nome);
				t3.setText(preco);
				t4.setText(descricao);
				t5.setText(id);
				t6.setText(dostex);
				t7.setText(forfra);
				t8.setText(admcor);
			}
		});
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //Define que apenas uma linha pode ser escolhida!	
	}
}
