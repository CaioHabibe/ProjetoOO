package model;

public class Dado {
	private Cliente [] clientes;
	private String [] nome = new String[50];
	private String [] cpf = new String[50];
	private String [] idade = new String[50];
	
	public Cliente[] getClientes() {
		return clientes;
	}
	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}
	public String[] getNome() {
		return nome;
	}
	public void setNome(String[] nome) {
		this.nome = nome;
	}
	public String[] getCpf() {
		return cpf;
	}
	public void setCpf(String[] cpf) {
		this.cpf = cpf;
	}
	public String[] getIdade() {
		return idade;
	}
	public void setIdade(String[] idade) {
		this.idade = idade;
	}

}
