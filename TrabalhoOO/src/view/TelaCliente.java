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

import controller.ControleCliente;

public class TelaCliente extends JFrame {

    private JTable table;

    private JTextField t1, t2, t3;
    private JButton b1, b2, b3;

    private final String[] colunas = new String[]{"Nome", "CPF", "idade"};

    public TelaCliente(ControleCliente cc) {

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
        
        table = new JTable(modelo);
        add(table);

        setLayout(new GridLayout(3, 3));
        JPanel painelC = new JPanel();
        painelC.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 20));
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

                if (t1.getText().toString().isEmpty() || t2.getText().toString().isEmpty() || t3.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor preencha os campos corretamente.", "Erro: ", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                	try {
                		cc.salvarCliente(t1.getText(), Long.valueOf(t2.getText()), Integer.valueOf(t3.getText()));
                    	modelo.addRow(new String[]{t1.getText(), t2.getText(), t3.getText()});
                    	JOptionPane.showMessageDialog(null, "Cliente cadastrado realizado com sucesso!");
                    	
                	} catch (RuntimeException e1) {
                		JOptionPane.showMessageDialog(null, "Por favor preencha os campos corretamente.", "Erro: ", JOptionPane.ERROR_MESSAGE);
                	}

                	t1.setText(null);
                    t2.setText(null);
                    t3.setText(null);

                }
            }
        });
             
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = table.rowAtPoint(e.getPoint());
                    int column = table.columnAtPoint(e.getPoint());

                    t1.setText((String) table.getValueAt(table.getSelectedRow(), 0));
                    t2.setText((String) table.getValueAt(table.getSelectedRow(), 1));
                    t3.setText((String) table.getValueAt(table.getSelectedRow(), 2));
                }
            }
        });
        
        b2 = new JButton("Atualizar");
        b2.setFont(new Font("SansSerif", Font.PLAIN, 17));
        b2.setFocusable(false);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (t1.getText().toString().isEmpty() || t2.getText().toString().isEmpty() || t3.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor preencha os campos corretamente.", "Erro: ", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                	
                	try {
                		cc.atualizarCliente(t1.getText(), Long.valueOf(t2.getText()), Integer.valueOf(t3.getText()),table.getSelectedRow());
                    	modelo.setValueAt(t1.getText(), table.getSelectedRow(), 0);
                    	modelo.setValueAt(t2.getText(), table.getSelectedRow(), 1);                	
                    	modelo.setValueAt(t3.getText(), table.getSelectedRow(), 2);
                    	JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
                    	
                	} catch (RuntimeException e1) {
                		JOptionPane.showMessageDialog(null, "Por favor preencha os campos corretamente.", "Erro: ", JOptionPane.ERROR_MESSAGE);
                	}
                }
            }
        });

        b3 = new JButton("Remover");
        b3.setFont(new Font("SansSerif", Font.PLAIN, 17));
        b3.setFocusable(false);
        b3.addActionListener(new ActionListener() {
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
        
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //Define que apenas uma linha pode ser escolhida!	
    }

}