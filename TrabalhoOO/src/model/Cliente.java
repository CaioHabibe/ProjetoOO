package model;

import java.util.ArrayList;

public class Cliente {
	private String nome;
	private int telefone;
	private int cpf;
	private int idade;
	private int email;
	private ArrayList<Carrinho> produtosComprados = new ArrayList<>();
	
	public Cliente() {}

	public Cliente(String nome, int telefone, int cpf, int idade, int email) {
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.idade = idade;
		this.email = email;
	}
	
	//Gets e Sets
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getEmail() {
		return email;
	}

	public void setEmail(int email) {
		this.email = email;
	}

	public ArrayList<Carrinho> getProdutosComprados() {
		return produtosComprados;
	}
	
	public ArrayList<Carrinho> listaDeProdutosComprados(ArrayList<Carrinho> lista){
		ArrayList<Carrinho > listaProdutos = new ArrayList<Carrinho>();
		for (Carrinho carrinho : lista) {
			listaProdutos.add(carrinho);
		}
		return listaProdutos;
	}
	
}