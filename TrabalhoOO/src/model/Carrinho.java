package model;

import java.util.ArrayList;

public class Carrinho {
	ArrayList<Produto> listaProdutosCarrinho;
	
	private Integer id;

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
	
	public void removeProdutoCarrinho(Produto produto) {
		 listaProdutosCarrinho.remove(produto);
	}
	
	public ArrayList<Produto> getListaProdutosCarrinho(){
		return listaProdutosCarrinho;
	}
	
}
