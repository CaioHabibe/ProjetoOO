package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
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
	ControleFilial cf = new ControleFilial();
	JTable table;
	
	JTextField t1,t2,t3;
	JButton b1, b2, b3;
	
	public TelaFilial(){
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
		
		String[] nomeColunas = {"CIDADE", "ENDEREÇO", "CNPJ"};
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
					String cidade = t1.getText();
					String endereco =  t2.getText();
					String cnpj = t3.getText();
					
					cf.salvarFilial(cidade, endereco, cnpj);
				
					modelo.addRow(cf.lerFilial());
					t1.setText(null);
					t2.setText(null);
					t3.setText(null);
					
					JOptionPane.showMessageDialog(null, "Cadastro de filial realizado com sucesso!");
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
					String cidade = t1.getText().toString();
					String endereco =  t2.getText().toString();
					String cnpj = t3.getText().toString();
					 
					cf.atualizarFilial(cidade, endereco, cnpj);

					
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
					int escolha = JOptionPane.showConfirmDialog(null, "Você realmente deseja apagar esta linha? \n" + "CIDADE: " 
																+ t1.getText() + "\n" + "ENDEREÇO: " + t2.getText() + "\n" +
																"CNPJ: " + t3.getText(), "Confirm", JOptionPane.YES_NO_OPTION);
					
					if (escolha == JOptionPane.YES_OPTION) {
						//System.out.println(cf.quantidadeFiliais());
						cf.removerFilial(table.getSelectedRow());
						//System.out.println(cf.quantidadeFiliais());
						modelo.removeRow(table.getSelectedRow());
					}
				}
			}
		});
		painelC.setLayout(new GridLayout(3, 3));
		painelC.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 20));
		
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
