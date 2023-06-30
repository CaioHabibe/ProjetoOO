package model;

import java.util.ArrayList;

public class Empresa {
	
	private String nome;
	private ArrayList<Filial> listaFiliaisCadastradas = new ArrayList<Filial>();
	private ArrayList<Cliente> listaClientesCadastrados = new ArrayList<Cliente>();
	
	public Empresa() {
		this.nome = "Farmácias FGA";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void adicionarCliente(Cliente cliente) {
		listaClientesCadastrados.add(cliente);
	}
	
	public void setListaFiliaisCadastradas(ArrayList<Filial> listaFiliaisCadastradas) {
		this.listaFiliaisCadastradas = listaFiliaisCadastradas;
	}

	public ArrayList<Filial> getListaFiliaisCadastradas() {
		return listaFiliaisCadastradas;
	}

	public ArrayList<Cliente> getListaClientesCadastrados() {
		return listaClientesCadastrados;
	}
	
//	public ArrayList<Filial> listagemFilialPorCidade(String cidade){
//		ArrayList<Filial> filtro = new ArrayList<>();
//		for(Filial filial : listaFiliaisCadastradas) {
//			if(filial.getCidade().contains(cidade)) {
//				filtro.add(filial);
//			}
//		}
//		return filtro;
//	}
	
	
	
}
