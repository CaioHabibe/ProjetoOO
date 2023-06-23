package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.Cliente;

public class TelaConsultaCliente {
	private List<Cliente> linhas;
    private String[] colunas = new String[] {"Nome", "CPF"};
	private JFrame frame;
	
	public void initialize() {
		frame = new JFrame("Consulta de cliente");
		frame.setSize(600, 300);
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
		
        JPanel titulo = new JPanel();
        JLabel txtTitulo = new JLabel("Consultar cliente");
        titulo.add(txtTitulo);
        
        JPanel consulta = new JPanel();
        JLabel lblConsultaCPF = new JLabel("Digite o CPF do cliente: ");
        JTextField txtConsultaCPF = new JTextField(18);
        JButton procurar = new JButton("Procurar");
        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltar();
            }
        });
        consulta.add(lblConsultaCPF);
        consulta.add(txtConsultaCPF);
        consulta.add(procurar);
        consulta.add(voltar);
        
        JPanel tabela = new JPanel(new GridLayout(2,1,10,10));
        String[] columnNames = {"Nome", "CPF"};        
        Object[][] data = {{"Lucas", "23123123123"},
        				   {"Caio",  "12312312312"},
        				   {"Artur", "32132132132"}};
        
        
        JTable table = new JTable(data, columnNames);
        JScrollPane scp = new JScrollPane(table);
        table.getTableHeader().setBounds(50,30,400,20);
        table.setBounds(50, 50, 400, 200);
        
        tabela.add(table.getTableHeader());
        tabela.add(table);
        
        
        
        frame.add(titulo, BorderLayout.NORTH);
        frame.add(consulta, BorderLayout.SOUTH);
        frame.add(tabela, BorderLayout.CENTER);
		frame.setVisible(true);
	}
	private void voltar() {
    	frame.dispose();
    	TelaCadastroCliente v = new TelaCadastroCliente();
    	v.initialize();
    }
}
