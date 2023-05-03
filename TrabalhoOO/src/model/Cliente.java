package model;

import java.util.ArrayList;
import java.util.Date;

public class Cliente {
	private String sexo;
	private String nome;
	private int telefone;
	private int cpf;
	private int idade;
	private ArrayList<Produto> produtosComprados;
	
	public Cliente (String sexo, int telefone, int cpf, int idade, String nome) {
		this.sexo = sexo;
		this.telefone = telefone;
		this.cpf = cpf;
		this.idade = idade;
		this.nome = nome;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public int getTelefone() {
		return telefone;
	}
	
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	public double getCpf() {
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
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return "Sexo: " + sexo + ", Telefone: " + telefone + 
				   ", CPF: " + cpf +", Idade: " + idade + ", Nome: " + nome;
	}
}