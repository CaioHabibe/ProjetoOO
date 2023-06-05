package model;

import java.util.ArrayList;

public class Carrinho {
	private int id;
	private ArrayList<Produto> carrinhoProdutos = new ArrayList<Produto>();
	
	public Carrinho() {};
	public Carrinho(int id) {this.id = id;}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public ArrayList<Produto> getCarrinhoProdutos() {
		return carrinhoProdutos;
	}
	
	public void addCarrinho(Produto produto) {
		this.carrinhoProdutos.add(produto);
	}
	
	public void excluiCarrinho(Produto produto) {
		this.carrinhoProdutos.remove(produto);
	}
	
	public ArrayList<Produto> fechaCarrinho(ArrayList<Produto> conteudo){
		ArrayList<Produto> fecha = new ArrayList<Produto>();
		for(Produto produto : conteudo) {
			fecha.add(produto);
		}
		return fecha;
	}
	
}
