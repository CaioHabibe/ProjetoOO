package model;

import java.util.ArrayList;

public class Filial {
	private String cidade;
	private String endereco;
	private int cep;
	private ArrayList<Produto> produtosCadastrados = new ArrayList<Produto>();
	private ArrayList<Carrinho> carrinhoRegistrado = new ArrayList<Carrinho>();
	
	
	public Filial() {};
	public Filial(String cidade, String endereco, int cep) {
		this.cidade = cidade;
		this.endereco = endereco;
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	
	public ArrayList<Produto> getProdutosCadastrados() {
		return produtosCadastrados;
	}
	
	public ArrayList<Produto> listaProdutosCadastrados(ArrayList<Produto> lista) {
		ArrayList<Produto> listagem = new ArrayList<Produto>();
		for(Produto produto : lista) {
			listagem.add(produto);
		}
		return listagem;
	}
	
	public Produto buscaProdutoNome(Produto produto) {
		int indexProduto = produtosCadastrados.indexOf(produto);
		return produtosCadastrados.get(indexProduto);
	}
	
	public void addProduto(Produto produto) {
		this.produtosCadastrados.add(produto);
	}
	
	public void excluiProduto(Produto produto) {
		this.produtosCadastrados.remove(produto);
	}
	
	@Override
	public String toString() {
		return "Filial [cidade=" + cidade + ", endereco=" + endereco + ", cep=" + cep + ", produtosCadastrados="
				+ produtosCadastrados + "]";
	}

	
}