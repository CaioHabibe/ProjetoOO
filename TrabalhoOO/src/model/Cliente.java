package model;

import java.util.ArrayList;

public class Cliente {
	
	private String nome;
	private String cpf;
	
	public Cliente() { }
	
	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void cadastrarCliente() {
		
	}
	
	public static ArrayList<Cliente> getClientes(){
		ArrayList<Cliente> clientes = new ArrayList<>();
		return clientes;
	}
	
}
