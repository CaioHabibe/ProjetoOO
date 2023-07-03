package model;

import java.util.ArrayList;

/**
 * Classe Carrinho, modelo de um Carrinho para o programa.
 * @author Caio
 * @since 2023
 */
public class Carrinho {
	ArrayList<Produto> listaProdutosCarrinho;
	
	private Integer id;

	/**
	 * Construtora da classe Carrinho.
	 */
	public Carrinho() {
		listaProdutosCarrinho = new ArrayList<>();
	}
	
	public Carrinho(Integer id) {
		this.id = id;
		listaProdutosCarrinho = new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public void addProdutoCarrinho(Produto produto) {
		listaProdutosCarrinho.add(produto);
	}
	
	/**
	 * Remove um Produto da lista de Produtos em um carrinho.
	 * @param produto
	 */
	public void removeProdutoCarrinho(Produto produto) {
		 listaProdutosCarrinho.remove(produto);
	}
	
	public ArrayList<Produto> getListaProdutosCarrinho(){
		return listaProdutosCarrinho;
	}
	
}
