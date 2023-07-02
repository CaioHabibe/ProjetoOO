package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
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
	
	private JTable tableRemedio;
	private JTable tableCosmetico;
	
	private JTextField t1,t2,t3,t4,t5,t6;
	private JButton b_salvar, b_atualizar, b_remover;
	
	private	JComboBox<String> comboBox = new JComboBox<>();
	
	private final String[] colunasRemedio = {"Tipo", "Nome", "Preço", "Descrição", "Dosagem", "Fórmula", "Administração"};
	
	private final String[] colunasCosmetico = {"Tipo", "Nome", "Preço", "Descrição", "Textura", "Fragrância", "Corante"};
	
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
        
        //Lendo dados de Remédio
        final var dadosRemedio = cp.lerRemedio();
        
        //Criando tabela para Remedio
        final var modeloRemedio = new DefaultTableModel(dadosRemedio, colunasRemedio) {
        	@Override
        	public boolean isCellEditable(int linhas, int colunas) {
        		if(colunas == 1) {
        			return false;
        		}else {
        			return false;
        		}
        	}
        };
        
        //lendo dados de cosmético
        final var dadosCosmetico = cp.lerCosmetico();
        
        //Criando tabela para Cosmético
        final var modeloCosmetico = new DefaultTableModel(dadosCosmetico, colunasCosmetico) {
        	@Override
        	public boolean isCellEditable(int linhas, int colunas) {
        		if(colunas == 1) {
        			return false;
        		}else {
        			return false;
        		}
        	}
        };
        
        //Criando tabelas para remédio e cosmético
        tableRemedio = new JTable(modeloRemedio);
        tableCosmetico = new JTable(modeloCosmetico);
        
        
        add(tableRemedio);
		add(tableCosmetico);
        
		setLayout(new FlowLayout());
		JPanel painelC = new JPanel();
		painelC.setBorder(BorderFactory.createEmptyBorder(20, 40, 40, 20));
		add(new JScrollPane(tableCosmetico));
		add(new JScrollPane(tableRemedio));
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

        b_salvar = new JButton("Salvar");
        b_salvar.setFont(new Font("SansSerif", Font.PLAIN, 17));
		b_salvar.setFocusable(false);
		
		b_atualizar = new JButton("Atualizar");	
		b_atualizar.setFont(new Font("SansSerif", Font.PLAIN, 17));
		b_atualizar.setFocusable(false);
		
		b_remover = new JButton("Remover");
		b_remover.setFont(new Font("SansSerif", Font.PLAIN, 17));
		b_remover.setFocusable(false);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                String selectedOption = (String) comboBox.getSelectedItem();
                
            }
        });
        
		b_salvar.addActionListener(new ActionListener() {
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
							modeloRemedio.addRow(new String[]{"Remédio",t1.getText(), t2.getText(), t3.getText(), t4.getText(), t5.getText(), t6.getText()});
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
							modeloCosmetico.addRow(new String[]{"Cosmético",t1.getText(), t2.getText(), t3.getText(), t4.getText(), t5.getText(), t6.getText()});
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
		
		tableRemedio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2) {
						int row = tableRemedio.rowAtPoint(e.getPoint());
						int column = tableRemedio.columnAtPoint(e.getPoint());

						t1.setText((String) tableRemedio.getValueAt(tableRemedio.getSelectedRow(), 1));
						t2.setText((String) tableRemedio.getValueAt(tableRemedio.getSelectedRow(), 2));
						t3.setText((String) tableRemedio.getValueAt(tableRemedio.getSelectedRow(), 3));
						t4.setText((String) tableRemedio.getValueAt(tableRemedio.getSelectedRow(), 4));
						t5.setText((String) tableRemedio.getValueAt(tableRemedio.getSelectedRow(), 5));
						t6.setText((String) tableRemedio.getValueAt(tableRemedio.getSelectedRow(), 6));
						
						if (tableRemedio.getValueAt(tableRemedio.getSelectedRow(), 0) == "Remédio") {
							comboBox.setSelectedItem("Remédio");
						}
				}
			}
		});
		
		tableCosmetico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2) {
						int row = tableCosmetico.rowAtPoint(e.getPoint());
						int column = tableCosmetico.columnAtPoint(e.getPoint());

						t1.setText((String) tableCosmetico.getValueAt(tableCosmetico.getSelectedRow(), 1));
						t2.setText((String) tableCosmetico.getValueAt(tableCosmetico.getSelectedRow(), 2));
						t3.setText((String) tableCosmetico.getValueAt(tableCosmetico.getSelectedRow(), 3));
						t4.setText((String) tableCosmetico.getValueAt(tableCosmetico.getSelectedRow(), 4));
						t5.setText((String) tableCosmetico.getValueAt(tableCosmetico.getSelectedRow(), 5));
						t6.setText((String) tableCosmetico.getValueAt(tableCosmetico.getSelectedRow(), 6));
						
						if (tableCosmetico.getValueAt(tableCosmetico.getSelectedRow(), 0) == "Cosmético") {
							comboBox.setSelectedItem("Cosmético");
						}
				}
			}
		});

		b_atualizar.addActionListener(new ActionListener() {	
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
							cp.atualizarRemedio(t1.getText(), Double.valueOf(t2.getText()), t3.getText(), t4.getText(), t5.getText(), t6.getText(), tableRemedio.getSelectedRow());
							modeloRemedio.setValueAt(t1.getText(), tableRemedio.getSelectedRow(), 1);                	
							modeloRemedio.setValueAt(t2.getText(), tableRemedio.getSelectedRow(), 2);
							modeloRemedio.setValueAt(t3.getText(), tableRemedio.getSelectedRow(), 3);
							modeloRemedio.setValueAt(t4.getText(), tableRemedio.getSelectedRow(), 4);
							modeloRemedio.setValueAt(t5.getText(), tableRemedio.getSelectedRow(), 5);
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
							cp.atualizarCosmetico(t1.getText(), Double.valueOf(t2.getText()), t3.getText(), t4.getText(), t5.getText(), t6.getText(), tableCosmetico.getSelectedRow());
							modeloCosmetico.setValueAt(t1.getText(), tableCosmetico.getSelectedRow(), 1);
							modeloCosmetico.setValueAt(t2.getText(), tableCosmetico.getSelectedRow(), 2);                	
							modeloCosmetico.setValueAt(t3.getText(), tableCosmetico.getSelectedRow(), 3);
							modeloCosmetico.setValueAt(t4.getText(), tableCosmetico.getSelectedRow(), 4);
							modeloCosmetico.setValueAt(t5.getText(), tableCosmetico.getSelectedRow(), 5);
							modeloCosmetico.setValueAt(t6.getText(), tableCosmetico.getSelectedRow(), 6);
							JOptionPane.showMessageDialog(null, "Cosmético atualizado com sucesso!");
							
						} catch (RuntimeException e1) {
							JOptionPane.showMessageDialog(null, "Por favor preencha os campos corretamente.", "Erro: ", JOptionPane.ERROR_MESSAGE);
						}
					}
				}			
			}
		});
		
		b_remover.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Remédio")){
					if(tableRemedio.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(null, "Por favor, selecione uma linha.", "Erro: ", JOptionPane.ERROR_MESSAGE);
					}
					else {
						int escolha = JOptionPane.showConfirmDialog(null, "Você realmente deseja remover este remédio? \n"
								+ "TIPO: " + tableRemedio.getValueAt(tableRemedio.getSelectedRow(), 0) + "\n"
								+ "NOME: " + tableRemedio.getValueAt(tableRemedio.getSelectedRow(), 1) + "\n"
								+ "PREÇO: " + tableRemedio.getValueAt(tableRemedio.getSelectedRow(), 2) + "\n"
								+ "DESCRIÇÃO: " + tableRemedio.getValueAt(tableRemedio.getSelectedRow(), 3) +"\n"
								+ "DOSAGEM: " + tableRemedio.getValueAt(tableRemedio.getSelectedRow(), 4) + "\n"
								+ "FÓRMULA: " + tableRemedio.getValueAt(tableRemedio.getSelectedRow(), 5) +"\n" 
								+ "ADMINISTRAÇÃO: " + tableRemedio.getValueAt(tableRemedio.getSelectedRow(), 6), "Confirm", JOptionPane.YES_NO_OPTION);

						if (escolha == JOptionPane.YES_OPTION) {
							cp.removerRemedio(tableRemedio.getSelectedRow());
							modeloRemedio.removeRow(tableRemedio.getSelectedRow());
							JOptionPane.showMessageDialog(null, "Remédio removido com sucesso!");
						}
					}
				}
				if(comboBox.getSelectedItem().equals("Cosmético")){
					if(tableCosmetico.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(null, "Por favor, selecione uma linha.", "Erro: ", JOptionPane.ERROR_MESSAGE);
					}
					else {
						int escolha = JOptionPane.showConfirmDialog(null, "Você realmente deseja remover este cosmético? \n"
								+ "TIPO: " + tableCosmetico.getValueAt(tableCosmetico.getSelectedRow(), 0) + "\n"
								+"NOME: " + tableCosmetico.getValueAt(tableCosmetico.getSelectedRow(), 1) + "\n"
								+ "PREÇO: " + tableCosmetico.getValueAt(tableCosmetico.getSelectedRow(), 2) + "\n"
								+ "DESCRIÇÃO: " + tableCosmetico.getValueAt(tableCosmetico.getSelectedRow(), 3) +"\n"
								+ "TEXTURA: " + tableCosmetico.getValueAt(tableCosmetico.getSelectedRow(), 4) + "\n"
								+ "FRAGRANCIA: " + tableCosmetico.getValueAt(tableCosmetico.getSelectedRow(), 5) +"\n" 
								+ "CORANTE: " + tableCosmetico.getValueAt(tableCosmetico.getSelectedRow(), 6), "Confirm", JOptionPane.YES_NO_OPTION);

						if (escolha == JOptionPane.YES_OPTION) {
							cp.removerCosmetico(tableCosmetico.getSelectedRow());
							modeloCosmetico.removeRow(tableCosmetico.getSelectedRow());
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
		
		painelBotoes.add(b_salvar);
		painelBotoes.add(b_atualizar);
		painelBotoes.add(b_remover);
		
		painelC.add(painelBotoes);
		
		validate();
		
		tableRemedio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //Define que apenas uma linha pode ser escolhida!	
		tableCosmetico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
			
}