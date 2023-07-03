package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controller.ControleCarrinho;
import controller.ControleCliente;
import controller.ControleFilial;
import controller.ControleProduto;

public class TelaCarrinho {
	private JTable tabelaFiliais; //esquerda
	private JTable tabelaProdutos; //central
	private JTable tabelaCarrinho; //esquerda
	private JFrame frame;
	
    static final String[] colunasPanelFiliais = new String[] {"Cidade", "Endereço"};
    static final String[] colunasProdutosCadastrados = new String[] {"Nome", "Preço"};
    static final String[] produtosAdiconados = new String[] {"Carrinho"}; 
    
    TableRowSorter<DefaultTableModel> trs;
    TableRowSorter<DefaultTableModel> trs2;
	
	public TelaCarrinho(ControleCliente cc, ControleFilial cf, ControleProduto cp, ControleCarrinho cca) {
		frame = new JFrame();
        frame.setTitle("Carrinho");
        frame.setSize(1600, 700);
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
        
        //panel esquerda
        JPanel panelFiliais = new JPanel();
        panelFiliais.setPreferredSize(new Dimension(500,70));
        final var dadosFilial = cf.lerFilial();
        DefaultTableModel modeloFilial = new DefaultTableModel(dadosFilial, colunasPanelFiliais) {
	        @Override
	    	public boolean isCellEditable(int linhas, int colunas) {
	    		if(colunas == 1) {
	    			return false;
	    		}else {
	    			return false;
	    		}
	    	}
        };
        tabelaFiliais = new JTable(modeloFilial);
        tabelaFiliais.setAutoCreateRowSorter(true);
        trs = new TableRowSorter<>(modeloFilial);
        tabelaFiliais.setRowSorter(trs);
        panelFiliais.add(new JScrollPane(tabelaFiliais), BorderLayout.SOUTH);       
        //fim panel esquerda
        
        //painel meio
        JPanel painelProdutosFilial = new JPanel();
        painelProdutosFilial.setPreferredSize(new Dimension(500, 70));
        final var dadosProdutos = cp.lerProduto();
        DefaultTableModel modeloProdutos = new DefaultTableModel(dadosProdutos, colunasProdutosCadastrados) {
        	@Override
	    	public boolean isCellEditable(int linhas, int colunas) {
	    		if(colunas == 1) {
	    			return false;
	    		}else {
	    			return false;
	    		}
	    	}
        }; 
        tabelaProdutos = new JTable(modeloProdutos);
        tabelaProdutos.setAutoCreateRowSorter(true);
        trs2 = new TableRowSorter<>(modeloProdutos);
        tabelaProdutos.setRowSorter(trs2);
        painelProdutosFilial.add(new JScrollPane(tabelaProdutos), BorderLayout.SOUTH);
        //fim painel central
        
        
        //Panel da direita
        JPanel panelProdutos = new JPanel();
        panelProdutos.setPreferredSize(new Dimension(500,70));
        final var modeloCarrinho = new DefaultTableModel(null, produtosAdiconados) {
        	@Override
	    	public boolean isCellEditable(int linhas, int colunas) {
	    		if(colunas == 1) {
	    			return false;
	    		}else {
	    			return false;
	    		}
	    	}
        };

        tabelaCarrinho = new JTable(modeloCarrinho);
        panelProdutos.add(new JScrollPane(tabelaCarrinho), BorderLayout.SOUTH);
        //fim panel da direita
        
        
        //panel de baixo
        JPanel panelBotoes = new JPanel();
        //panelBotoes.setBackground(Color.blue);
        panelBotoes.setPreferredSize(new Dimension(600,110));
        
        JButton add = new JButton("Adicionar");
        add.setFocusable(false);
        add.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        
        JButton remove = new JButton("Remover");
        remove.setFocusable(false);
        
        JButton comprar = new JButton("Finalizar compra");
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
        
        JPanel procurarFilial = new JPanel();
        procurarFilial.setVisible(true);
        //procurarFilial.setBackground(Color.green);
        procurarFilial.setPreferredSize(new Dimension(100,100));
        
        JLabel lblProcura = new JLabel("Digite a sua cidade: ");
        
        JTextField txtProcura = new JTextField(20);
        //Atualiza a tabela plotada
        JButton Procurar = new JButton("Procurar");
        Procurar.setFocusable(false);
        Procurar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				trs.setRowFilter(RowFilter.regexFilter(txtProcura.getText(),0));
			}
		});
       
        JLabel lblNome = new JLabel("Digite o nome do produto a ser buscado: ");
        JTextField txtNome = new JTextField(20);
        JButton filtraNome = new JButton("Buscar");

        procurarFilial.add(lblNome);
        procurarFilial.add(txtNome);
        procurarFilial.add(filtraNome);
        
        procurarFilial.add(lblProcura);
        procurarFilial.add(txtProcura);
        procurarFilial.add(Procurar);
        
        filtraNome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				trs2.setRowFilter(RowFilter.regexFilter(txtNome.getText(),0));
			}
		});
        
        frame.add(procurarFilial, BorderLayout.NORTH);
        frame.add(panelBotoes, BorderLayout.SOUTH);
        frame.add(panelFiliais, BorderLayout.WEST);
        frame.add(painelProdutosFilial, BorderLayout.CENTER);
        frame.add(panelProdutos, BorderLayout.EAST);
        
        frame.setVisible(true);
	}
	
	private void voltar() {
    	frame.dispose();
    }
	
}