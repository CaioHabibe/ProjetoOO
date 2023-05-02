package model;

public abstract class Produto {
	protected int id;
	protected String nome;
	protected String marca;
	protected double preco;
	protected String descricao;
	protected int qtd;
	
	public Produto() {
		super();
	}
	
	public Produto(int identificacao, String nome, String marca, double preco,
			String descricao, int qtd) {
		this.id = identificacao;
		this.nome = nome;
		this.marca = marca;
		this.preco = preco;
		this.descricao = descricao;
		this.qtd = qtd;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id ) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getQtd() {
		return qtd;
	}
	
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
}