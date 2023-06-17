package model;

public abstract class Produto {
	
	protected String nome;
	protected double preco;
	protected String descricao;
	protected long id;
	
	public Produto(String nome, double preco, String descricao, long id) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getDescicao() {
		return descricao;
	}
	public void setDescicao(String descicao) {
		this.descricao = descicao;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
