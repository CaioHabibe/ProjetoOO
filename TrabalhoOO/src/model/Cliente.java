package model;

import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String telefone;
	private String cpf;
	private int idade;
	private String email;
	private Carrinho carrinho = new Carrinho();
	private ArrayList<Produto> produtosComprados = new ArrayList<>();
	
	public Cliente() {}

	public Cliente(String nome, String telefone, String cpf, int idade, String email) {
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Produto> getProdutosComprados() {
		return produtosComprados;
	}
	
	
	public ArrayList<Produto> listaDeProdutosComprados(ArrayList<Produto> lista){
		ArrayList<Produto> listaProdutos = new ArrayList<>();
		for (Produto produto : lista) {
			listaProdutos.add(produto);
		}
		return listaProdutos;
	}
	
}