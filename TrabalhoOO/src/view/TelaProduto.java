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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controller.ControleProduto;

public class TelaProduto extends JFrame{
	
	private JTable table;
	
	private JTextField t1,t2,t3,t4,t5,t6;
	private JButton b1, b2, b3;
	
	private	JComboBox<String> comboBox = new JComboBox<>();
	
	private final String[] colunas = {"Tipo", "Nome", "Preço", "Descrição", "Dosagem/Textura", "Fórmula/Fragrância", "Administração/Corante"};
	
	TelaProduto(ControleProduto cp){
		
		setSize(1100, 800);
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
        
        final var dados = cp.lerProduto();
        final var modelo = new DefaultTableModel(dados, colunas) {
        	@Override
        	public boolean isCellEditable(int linhas, int colunas) {
        		if(colunas == 1) {
        			return false;
        		}else {
        			return false;
        		}
        	}
        };
        
        table = new JTable(modelo);
        add(table);
		
		setLayout(new GridLayout(3, 8));
		JPanel painelC = new JPanel();
		painelC.setBorder(BorderFactory.createEmptyBorder(20, 40, 40, 20));
		add(new JScrollPane(table));
		add(new JPanel());
		add(painelC);
		
        comboBox.addItem("Selecione uma opção");
        comboBox.addItem("Remédio");
        comboBox.addItem("Cosmético");

		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();
		t6 = new JTextField();

        b1 = new JButton("Salvar");
        b1.setFont(new Font("SansSerif", Font.PLAIN, 17));
		b1.setFocusable(false);
		
		b2 = new JButton("Atualizar");	
		b2.setFont(new Font("SansSerif", Font.PLAIN, 17));
		b2.setFocusable(false);
		
		b3 = new JButton("Remover");
		b3.setFont(new Font("SansSerif", Font.PLAIN, 17));
		b3.setFocusable(false);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                String selectedOption = (String) comboBox.getSelectedItem();
                
                
                
            }
        });

		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				if(comboBox.getSelectedItem().equals("Remédio")){
					if(t1.getText().toString().isEmpty() || t2.getText().toString().isEmpty()
							|| t3.getText().toString().isEmpty() || t4.getText().toString().isEmpty() || t5.getText().toString().isEmpty()
							|| t6.getText().toString().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por favor preencha os campos corretamente.", "Erro: ", JOptionPane.ERROR_MESSAGE);
						return;
					}
					else {
						try {
							cp.salvarRemedio(t1.getText(), Double.valueOf(t2.getText()), t3.getText(), t4.getText(), t5.getText(), t6.getText(), "RÉMEDIO");
							modelo.addRow(new String[]{"Remédio",t1.getText(), t2.getText(), t3.getText(), t4.getText(), t5.getText(), t6.getText()});
							JOptionPane.showMessageDialog(null, "Remédio cadastrado com sucesso!");
							
						} catch (RuntimeException e1) {
							JOptionPane.showMessageDialog(null, "Por favor preencha os campos corretamente.", "Erro: ", JOptionPane.ERROR_MESSAGE);
						}
						t1.setText(null);
						t2.setText(null);
						t3.setText(null);
						t4.setText(null);
						t5.setText(null);
						t6.setText(null);
					}
				}
				if(comboBox.getSelectedItem().equals("Cosmético")){
					if(t1.getText().toString().isEmpty() || t2.getText().toString().isEmpty()
							|| t3.getText().toString().isEmpty() || t4.getText().toString().isEmpty() || t5.getText().toString().isEmpty()
							|| t6.getText().toString().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por favor preencha os campos corretamente.", "Erro: ", JOptionPane.ERROR_MESSAGE);
						return;
					}
					else {
						try {
							cp.salvarCosmetico(t1.getText(), Double.valueOf(t2.getText()), t3.getText(), t4.getText(), t5.getText(), t6.getText(),"Cosmético");
							modelo.addRow(new String[]{"Cosmético",t1.getText(), t2.getText(), t3.getText(), t4.getText(), t5.getText(), t6.getText()});
							JOptionPane.showMessageDialog(null, "Cosmético cadastrado com sucesso!");
							
						} catch (RuntimeException e1) {
							JOptionPane.showMessageDialog(null, "Por favor preencha os campos corretamente.", "Erro: ", JOptionPane.ERROR_MESSAGE);
						}
						t1.setText(null);
						t2.setText(null);
						t3.setText(null);
						t4.setText(null);
						t5.setText(null);
						t6.setText(null);
					}
				}		
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(comboBox.getSelectedItem().equals("Remédio")){
					if (e.getClickCount() == 2) {
						int row = table.rowAtPoint(e.getPoint());
						int column = table.columnAtPoint(e.getPoint());

						t1.setText((String) table.getValueAt(table.getSelectedRow(), 1));
						t2.setText((String) table.getValueAt(table.getSelectedRow(), 2));
						t3.setText((String) table.getValueAt(table.getSelectedRow(), 3));
						t4.setText((String) table.getValueAt(table.getSelectedRow(), 4));
						t5.setText((String) table.getValueAt(table.getSelectedRow(), 5));
						t6.setText((String) table.getValueAt(table.getSelectedRow(), 6));
					}
				}

				if(comboBox.getSelectedItem().equals("Cosmético")){
					if (e.getClickCount() == 2) {
						int row = table.rowAtPoint(e.getPoint());
						int column = table.columnAtPoint(e.getPoint());

						t1.setText((String) table.getValueAt(table.getSelectedRow(), 1));
						t2.setText((String) table.getValueAt(table.getSelectedRow(), 2));
						t3.setText((String) table.getValueAt(table.getSelectedRow(), 3));
						t4.setText((String) table.getValueAt(table.getSelectedRow(), 4));
						t5.setText((String) table.getValueAt(table.getSelectedRow(), 5));
						t6.setText((String) table.getValueAt(table.getSelectedRow(), 6));
                    }
				}
			}
		});

		b2.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Remédio")){
					if(t1.getText().toString().isEmpty() || t2.getText().toString().isEmpty()
						|| t3.getText().toString().isEmpty() || t4.getText().toString().isEmpty() || t5.getText().toString().isEmpty()
						|| t6.getText().toString().isEmpty())  {
					JOptionPane.showMessageDialog(null, "Por favor preencha os campos corretamente.", "Erro: ", JOptionPane.ERROR_MESSAGE);
					return;
					}
					else {
						try {
							cp.atualizarRemedio(t1.getText(), Double.valueOf(t2.getText()), t3.getText(), t4.getText(), t5.getText(), t6.getText(), table.getSelectedRow());
							modelo.setValueAt(t1.getText(), table.getSelectedRow(), 1);                	
							modelo.setValueAt(t2.getText(), table.getSelectedRow(), 2);
							modelo.setValueAt(t3.getText(), table.getSelectedRow(), 3);
							modelo.setValueAt(t4.getText(), table.getSelectedRow(), 4);
							modelo.setValueAt(t5.getText(), table.getSelectedRow(), 5);
							JOptionPane.showMessageDialog(null, "Atualização de remédio realizada com sucesso!");
							
						} catch (RuntimeException e1) {
							JOptionPane.showMessageDialog(null, "Por favor preencha os campos corretamente.", "Erro: ", JOptionPane.ERROR_MESSAGE);
						}
					}	
				}
				if(comboBox.getSelectedItem().equals("Cosmético")){
					if(t1.getText().toString().isEmpty() || t2.getText().toString().isEmpty()
							|| t3.getText().toString().isEmpty() || t4.getText().toString().isEmpty() || t5.getText().toString().isEmpty()
							|| t6.getText().toString().isEmpty())  {
						JOptionPane.showMessageDialog(null, "Por favor preencha os campos corretamente.", "Erro: ", JOptionPane.ERROR_MESSAGE);
						return;
					}
					else {
						try {
							cp.atualizarCosmetico(t1.getText(), Double.valueOf(t2.getText()), t3.getText(), t4.getText(), t5.getText(), t6.getText(), table.getSelectedRow());
							modelo.setValueAt(t1.getText(), table.getSelectedRow(), 1);
							modelo.setValueAt(t2.getText(), table.getSelectedRow(), 2);                	
							modelo.setValueAt(t3.getText(), table.getSelectedRow(), 3);
							modelo.setValueAt(t4.getText(), table.getSelectedRow(), 4);
							modelo.setValueAt(t5.getText(), table.getSelectedRow(), 5);
							modelo.setValueAt(t6.getText(), table.getSelectedRow(), 6);
							JOptionPane.showMessageDialog(null, "Cosmético atualizado com sucesso!");
							
						} catch (RuntimeException e1) {
							JOptionPane.showMessageDialog(null, "Por favor preencha os campos corretamente.", "Erro: ", JOptionPane.ERROR_MESSAGE);
						}
					}
				}			
			}
		});
		
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Remédio")){
					if(table.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(null, "Por favor, selecione uma linha.", "Erro: ", JOptionPane.ERROR_MESSAGE);
					}else {
						int escolha = JOptionPane.showConfirmDialog(null, "Você realmente deseja remover este remédio? \n"
								+ "TIPO: " + table.getValueAt(table.getSelectedRow(), 0) + "\n"
								+ "NOME: " + table.getValueAt(table.getSelectedRow(), 1) + "\n"
								+ "PREÇO: " + table.getValueAt(table.getSelectedRow(), 2) + "\n"
								+ "DESCRIÇÃO: " + table.getValueAt(table.getSelectedRow(), 3) +"\n"
								+ "DOSAGEM: " + table.getValueAt(table.getSelectedRow(), 4) + "\n"
								+ "FÓRMULA: " + table.getValueAt(table.getSelectedRow(), 5) +"\n" 
								+ "ADMINISTRAÇÃO: " + table.getValueAt(table.getSelectedRow(), 6), "Confirm", JOptionPane.YES_NO_OPTION);

						if (escolha == JOptionPane.YES_OPTION) {
							cp.removerRemedio(table.getSelectedRow());
							modelo.removeRow(table.getSelectedRow());
							JOptionPane.showMessageDialog(null, "Remédio removido com sucesso!");
						}
					}
				}
				if(comboBox.getSelectedItem().equals("Cosmético")){
					if(table.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(null, "Por favor, selecione uma linha.", "Erro: ", JOptionPane.ERROR_MESSAGE);
					}
					else {
						int escolha = JOptionPane.showConfirmDialog(null, "Você realmente deseja remover este cosmético? \n"
								+ "TIPO: " + table.getValueAt(table.getSelectedRow(), 0) + "\n"
								+"NOME: " + table.getValueAt(table.getSelectedRow(), 1) + "\n"
								+ "PREÇO: " + table.getValueAt(table.getSelectedRow(), 2) + "\n"
								+ "DESCRIÇÃO: " + table.getValueAt(table.getSelectedRow(), 3) +"\n"
								+ "TEXTURA: " + table.getValueAt(table.getSelectedRow(), 4) + "\n"
								+ "FRAGRANCIA: " + table.getValueAt(table.getSelectedRow(), 5) +"\n" 
								+ "CORANTE: " + table.getValueAt(table.getSelectedRow(), 6), "Confirm", JOptionPane.YES_NO_OPTION);

						if (escolha == JOptionPane.YES_OPTION) {
							cp.removerCosmetico(table.getSelectedRow());
							modelo.removeRow(table.getSelectedRow());
							JOptionPane.showMessageDialog(null, "Cosmético removido com sucesso!");
						}
					}
				}
			}
		});

        painelC.setLayout(new GridLayout(9, 2));
        
		JPanel painelBotoes = new JPanel(new GridLayout(1, 3));
        
		painelC.add(new JLabel("Tipo:"));
		painelC.add(comboBox);
		
		painelC.add(new JLabel("Nome:"));
		painelC.add(t1);
		
		painelC.add(new JLabel("Preço:"));
		painelC.add(t2);
		
		painelC.add(new JLabel("Descrição"));
		painelC.add(t3);
		
		painelC.add(new JLabel("Dosagem/Textura"));
		painelC.add(t4);
		
		painelC.add(new JLabel("Fórmula/Fragrância"));
		painelC.add(t5);
		
		painelC.add(new JLabel("Administração/Corante"));
		painelC.add(t6);
		
		painelBotoes.add(b1);
		painelBotoes.add(b2);
		painelBotoes.add(b3);
		
		painelC.add(painelBotoes);
		
		validate();
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //Define que apenas uma linha pode ser escolhida!	
	}
}