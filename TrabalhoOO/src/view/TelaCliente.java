package view;

import java.awt.*;
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

import controller.ControleCliente;

public class TelaCliente extends JFrame {

    private JTable table, tableListagem;

    private JTextField textoNome, textoCPF, textoRemover;
    private JButton btnSalvar, btnAtualizar, btnRemover, btnListar;

    private final String[] colunas = new String[]{"Nome", "CPF", "idade"};
    private final String[] colunaListagem = new String[]{"Nome"};
    
    public TelaCliente(ControleCliente cc) {

        setSize(900, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        
        //Abrir a view no centro da tela
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = getWidth();
        int frameHeight = getHeight();
        int xPos = (screenWidth - frameWidth) / 2;
        int yPos = (screenHeight - frameHeight) / 2;
        setLocation(xPos, yPos);
        
        //Layout da Table de cima
        final var dados = cc.lerCliente();
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
        
        //Layout da Table debaixo
        final var dadoListagem = cc.lerCliente();
        final var modeloListagem = new DefaultTableModel(dadoListagem, colunaListagem) {
        	@Override
        	public boolean isCellEditable(int linhas, int colunas) {
        		if(colunas == 1) {
        			return false;
        		}else {
        			return false;
        		}
        	}
        };
        
        //Criando as tables e adicionando no frame
        table = new JTable(modelo);
        tableListagem = new JTable(modeloListagem);

        add(table);
        add(tableListagem);
        
        
        setLayout(new GridLayout(4, 3));
        add(new JScrollPane(table));
        add(new JScrollPane(tableListagem));
        add(new JPanel());
        
        //Criando o painel os botoes e textos
        JPanel painelC = new JPanel();
        painelC.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 20));
        painelC.setPreferredSize(new Dimension(100,220));
        add(painelC,BorderLayout.SOUTH);
        
        //Caixas de texto
        textoNome = new JTextField();
        textoCPF = new JTextField();
        textoRemover = new JTextField();
        
        
        //Botao salvar
        btnSalvar = new JButton("Salvar");
        btnSalvar.setFont(new Font("SansSerif", Font.PLAIN, 17));
        btnSalvar.setFocusable(false);
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (textoNome.getText().toString().isEmpty() || textoCPF.getText().toString().isEmpty() || textoRemover.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor preencha os campos corretamente.", "Erro: ", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                	try {
                		cc.salvarCliente(textoNome.getText(), Long.valueOf(textoCPF.getText()), Integer.valueOf(textoRemover.getText()));
                    	modelo.addRow(new String[]{textoNome.getText(), textoCPF.getText(), textoRemover.getText()});
                    	JOptionPane.showMessageDialog(null, "Cliente cadastrado realizado com sucesso!");
                    	
                	} catch (RuntimeException e1) {
                		JOptionPane.showMessageDialog(null, "Por favor preencha os campos corretamente.", "Erro: ", JOptionPane.ERROR_MESSAGE);
                	}

                	textoNome.setText(null);
                    textoCPF.setText(null);
                    textoRemover.setText(null);

                }
            }
        });
        
        //Table de cima     
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = table.rowAtPoint(e.getPoint());
                    int column = table.columnAtPoint(e.getPoint());

                    textoNome.setText((String) table.getValueAt(table.getSelectedRow(), 0));
                    textoCPF.setText((String) table.getValueAt(table.getSelectedRow(), 1));
                    textoRemover.setText((String) table.getValueAt(table.getSelectedRow(), 2));
                }
            }
        });
        
        //Botao Atualizar
        btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setFont(new Font("SansSerif", Font.PLAIN, 17));
        btnAtualizar.setFocusable(false);
        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (textoNome.getText().toString().isEmpty() || textoCPF.getText().toString().isEmpty() || textoRemover.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor preencha os campos corretamente.", "Erro: ", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                	
                	try {
                		cc.atualizarCliente(textoNome.getText(), Long.valueOf(textoCPF.getText()), Integer.valueOf(textoRemover.getText()),table.getSelectedRow());
                    	modelo.setValueAt(textoNome.getText(), table.getSelectedRow(), 0);
                    	modelo.setValueAt(textoCPF.getText(), table.getSelectedRow(), 1);                	
                    	modelo.setValueAt(textoRemover.getText(), table.getSelectedRow(), 2);
                    	JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
                    	
                	} catch (RuntimeException e1) {
                		JOptionPane.showMessageDialog(null, "Por favor preencha os campos corretamente.", "Erro: ", JOptionPane.ERROR_MESSAGE);
                	}
                }
            }
        });
        
        //Botao remover
        btnRemover = new JButton("Remover");
        btnRemover.setFont(new Font("SansSerif", Font.PLAIN, 17));
        btnRemover.setFocusable(false);
        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione uma linha.", "Erro: ", JOptionPane.ERROR_MESSAGE);
                } else {
                    int escolha = JOptionPane.showConfirmDialog(null, "Você realmente deseja remover esta cliente? \n" +
                            "NOME: " + table.getValueAt(table.getSelectedRow(), 0) + "\n"
                            + "CPF: " + table.getValueAt(table.getSelectedRow(), 1) + "\n"
                            + "IDADE: " + table.getValueAt(table.getSelectedRow(), 2), "Confirm", JOptionPane.YES_NO_OPTION);

                    if (escolha == JOptionPane.YES_OPTION) {
                    	cc.removerCliente(table.getSelectedRow());
                    	modelo.removeRow(table.getSelectedRow());
                    	JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
                    }
                }
            }
        });
        
        //Botao Listar
        btnListar = new JButton("Listar");
        btnListar.setFont(new Font("SansSerif", Font.PLAIN, 17));
        btnListar.setFocusable(false);
        
        //Adicionando componentes ao painel
        painelC.setLayout(new GridLayout(4, 3));
       
        painelC.add(new JLabel("Nome:"));
        painelC.add(textoNome);
        painelC.add(btnSalvar);

        painelC.add(new JLabel("CPF:"));
        painelC.add(textoCPF);
        painelC.add(btnAtualizar);

        painelC.add(new JLabel("Idade:"));
        painelC.add(textoRemover);
        painelC.add(btnRemover);
       
        painelC.add(new JPanel());
        painelC.add(new JPanel());
        painelC.add(btnListar);
        
        validate();
        
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //Define que apenas uma linha pode ser escolhida!	
    }

}