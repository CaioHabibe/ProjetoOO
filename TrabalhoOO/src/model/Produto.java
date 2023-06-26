package model;

public abstract class Produto {
	
	protected String nome;
	protected double preco;
	protected String descricao;
	
	public Produto(String nome, double preco, String descricao) {
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
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
	
}
