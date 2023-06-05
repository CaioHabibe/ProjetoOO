package model;

public abstract class Produto {
	protected String nome;
	protected String marca;
	protected double preco;
	protected int qtd;
	
	public Produto(String nome, String marca, double preco, int qtd) {
		this.nome = nome;
		this.marca = marca;
		this.preco = preco;
		this.qtd = qtd;
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
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", marca=" + marca + ", preco=" + preco + ", qtd=" + qtd + "]";
	}
	
	
	
}