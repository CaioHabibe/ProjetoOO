package model;

import java.util.ArrayList;

public class Empresa {
	private String nome;
	private ArrayList<Filial> filiaisCadastradas;
	private ArrayList<Cliente> clientesCadastrados;
	
	public Empresa() {};
	
	public Empresa(String nome) {this.nome = nome;}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Filial> getFiliaisCadastradas() {
		return filiaisCadastradas;
	}

	public ArrayList<Cliente> getClientesCadastrados() {
		return clientesCadastrados;
	}
	
	public ArrayList<Filial> listagemFiliaisCidade(ArrayList<Filial> lista){
		ArrayList<Filial> filiaisCidade = new ArrayList<Filial>();
		for (Filial filial : lista) {
			filiaisCidade.add(filial);
		}
		return filiaisCidade;
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

	@Override
	public String toString() {
		return "Empresa [nome=" + nome + 
				", filiaisCadastradas=" + filiaisCadastradas + 
				", clientesCadastrados="+ clientesCadastrados + "]";
	}
}
