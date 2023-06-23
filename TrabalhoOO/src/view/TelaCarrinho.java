package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TelaCarrinho {
	private JFrame frame;
	
	public void initialize() {
		frame = new JFrame();
        frame.setTitle("Carrinho");
        frame.setSize(1200, 800);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        JLabel lblProcura = new JLabel("Digite a sua cidade: ");
        JTextField txtProcura = new JTextField(20);
        JButton Procurar = new JButton("Procurar");
        Procurar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
        procurarFilial.add(lblProcura);
        procurarFilial.add(txtProcura);
        procurarFilial.add(Procurar);
        
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
        
        frame.add(procurarFilial);
        frame.add(FiliaisEProdutos, BorderLayout.CENTER);
        frame.setVisible(true);
	}
}
