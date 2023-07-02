package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class TelaCarrinho {
	
	private JFrame frame;
	
	public TelaCarrinho() {
		frame = new JFrame();
        frame.setTitle("Carrinho");
        frame.setSize(1000, 700);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = frame.getWidth();
        int frameHeight = frame.getHeight();
        int xPos = (screenWidth - frameWidth) / 2;
        int yPos = (screenHeight - frameHeight) / 2;
        frame.setLocation(xPos, yPos);
        
        JPanel procurarFilial = new JPanel();
        procurarFilial.setVisible(true);
        //procurarFilial.setBackground(Color.green);
        procurarFilial.setPreferredSize(new Dimension(100,100));
        
        JLabel lblProcura = new JLabel("Digite a sua cidade: ");
        
        JTextField txtProcura = new JTextField(20);
        
        JButton Procurar = new JButton("Procurar");
        Procurar.setFocusable(false);
        Procurar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
        
        procurarFilial.add(lblProcura);
        procurarFilial.add(txtProcura);
        procurarFilial.add(Procurar);
        
        
        //panel esquerda
        JPanel panelFiliais = new JPanel();
        //panelFiliais.setBackground(Color.green);
        panelFiliais.setPreferredSize(new Dimension(500,70));
        
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Nome");
        tableModel.addColumn("Idade");
        tableModel.addRow(new Object[]{"João", 25});
        tableModel.addRow(new Object[]{"Maria", 30});
        JTable tabelaFiliais = new JTable();
      
        panelFiliais.add(new JScrollPane(tabelaFiliais), BorderLayout.SOUTH);
        //fim panel esquerda
        
        
        //Panel da direita
        JPanel panelProdutos = new JPanel();
       //panelProdutos.setBackground(Color.red);
        panelProdutos.setPreferredSize(new Dimension(500,70));
        
        DefaultTableModel tableModelP = new DefaultTableModel();
        tableModel.addColumn("Nome");
        tableModel.addColumn("Idade");
        tableModel.addRow(new Object[]{"João", 25});
        tableModel.addRow(new Object[]{"Maria", 30});
        JTable tabelaProdutos = new JTable();
      
        panelProdutos.add(new JScrollPane(tabelaProdutos), BorderLayout.SOUTH);
        
        //fim panel da direita
        
        
        //panel de baixo
        JPanel panelBotoes = new JPanel();
        //panelBotoes.setBackground(Color.blue);
        panelBotoes.setPreferredSize(new Dimension(600,110));
        
        JButton add = new JButton("Adicionar");
        add.setFocusable(false);
        
        JButton remove = new JButton("Remover");
        remove.setFocusable(false);
        
        JButton comprar = new JButton("Fechar carrinho");
        comprar.setFocusable(false);
        
        JButton back = new JButton("Voltar");
        back.setFocusable(false);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltar();
            }
        });
        
        panelBotoes.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER, 30, 30));
        
        panelBotoes.add(add);
        panelBotoes.add(remove);
        panelBotoes.add(comprar);
        panelBotoes.add(back);
        
        //fim panel de baixo
        
        
        /*
        JPanel FiliaisEProdutos = new JPanel(new GridLayout(2, 2, 10, 10));
        FiliaisEProdutos.setPreferredSize(new Dimension(400, 200));
        FiliaisEProdutos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        FiliaisEProdutos.setAlignmentX(Component.CENTER_ALIGNMENT);
        	
        
        String[] columnNames = {"Cidade", "Endereço"};        
        Object[][] data = {{"Brasília", "QD 5 CONJ 6"},
        				   {"São Paulo",  "QD 8 CONJ 14"},
        				   {"Rio de Janeiro", "QD 2 CONJ 17"}};
        
        
        JTable table = new JTable(data, columnNames);
        JScrollPane scp = new JScrollPane(table);
        table.getTableHeader().setBounds(50,30,100,20);
        table.setBounds(50, 50, 100, 100);
        
        FiliaisEProdutos.add(table.getTableHeader());
        FiliaisEProdutos.add(table);
        */
        
        frame.add(procurarFilial, BorderLayout.NORTH);
        frame.add(panelBotoes, BorderLayout.SOUTH);
        frame.add(panelFiliais, BorderLayout.WEST);
        frame.add(panelProdutos, BorderLayout.EAST);
        
        frame.setVisible(true);
	}
	
	private void voltar() {
    	frame.dispose();
    }
}