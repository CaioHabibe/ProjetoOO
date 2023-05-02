package model;

import java.util.ArrayList;
import java.util.Date;

public class Cliente {
	private String sexo;
	private int telefone;
	private Date dtNascimento;
	private String cpf;
	private int idade;
	private String nome;
	private ArrayList<Produto> produtosComprados;
	
	public Cliente (String sexo, int telefone, String cpf, int idade, String nome) {
		this.sexo = sexo;
		this.telefone = telefone;
		this.cpf = cpf;
		this.idade = idade;
		this.nome = nome;
	}
	public Cliente () {
		
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
	
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
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
	
	public String getNome() {
		return nome;
	}
	public void setIdade(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return "Sexo: " + sexo + ", Telefone: " + telefone + 
				   ", CPF: " + cpf +", Idade: " + idade + ", Nome: " + nome;
	}
	
}
