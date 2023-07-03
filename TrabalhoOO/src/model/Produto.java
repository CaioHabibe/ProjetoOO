package model;

/**
 * Classe abstrata Produto serve apenas para herança das classes Remedio e Produto.
 * @author Caio
 * @since 2023
 */
public abstract class Produto {
	
	protected String nome;
	protected double preco;
	protected String descricao;
	
	/**
	 * Construtor da classe Produto.
	 * @param nome
	 * @param preco
	 * @param descricao
	 */
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
	
	/**
	 * Metodo que retorna a descricao do produto em forma de String, funciona como um get.
	 * @return String
	 */
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descicao) {
		this.descricao = descicao;
	}
	
}
