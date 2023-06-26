package model;

import java.util.ArrayList;

public class Filial {
	private ArrayList<Produto> listaProdutosCadastrados; 
	
	private String cidade;
	private String endereco;
	private String cnpj;
	
	public Filial() {
		listaProdutosCadastrados = new ArrayList<Produto>();
	}

	public Filial(String cidade, String endereco, String cnpj) {
		this.cidade = cidade;
		this.endereco = endereco;
		this.cnpj = cnpj;
		listaProdutosCadastrados = new ArrayList<Produto>();
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public ArrayList<Produto> getListaProdutosCadastrados(){
		return listaProdutosCadastrados;
	}
	
	public void addProduto(Produto p) {
		listaProdutosCadastrados.add(p);
	}
	
	public void removeProduto(Produto p) {
		listaProdutosCadastrados.remove(p);
	}
	
	
	@Override
	public String toString() {
		return "Filial [cidade=" + cidade + ", endereco=" + endereco + ", cnpj=" + cnpj + "]";
	}
	
}
