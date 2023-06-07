package model;

import java.util.ArrayList;

public class Empresa {
	private String nome;
	private ArrayList<Filial> filiaisCadastradas = new ArrayList<>();
	private ArrayList<Cliente> clientesCadastrados = new ArrayList<>();
	
	public Empresa() {};
	public Empresa(String nome) {this.nome = nome;}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Filial> getFiliaisCadastradas() {
		return this.filiaisCadastradas;
	}
	public ArrayList<Cliente> getClientesCadastrados() {
		return this.clientesCadastrados;
	}
	public void addFilial(Filial filial) {
		this.filiaisCadastradas.add(filial);
	}
	public void excluiFilial(Filial filial) {
		this.filiaisCadastradas.remove(filial);
	}
	public void addCliente(Cliente c) {
		this.clientesCadastrados.add(c);
	}
	public void excluiCliente(Cliente c) {
		this.clientesCadastrados.remove(c);
	}

	public ArrayList<Filial> listagemFiliaisCidade(String nomeCidade){
		ArrayList<Filial> filiaisCidade = new ArrayList<Filial>();
		for (Filial filial : filiaisCadastradas) {
			if (filial.getCidade() == nomeCidade){
				filiaisCidade.add(filial);
			};
		}
		return filiaisCidade;
	}
	
	@Override
	public String toString() {
		return "Empresa [nome=" + nome + 
				", filiaisCadastradas=" + filiaisCadastradas + 
				", clientesCadastrados="+ clientesCadastrados + "]";
	}
}
