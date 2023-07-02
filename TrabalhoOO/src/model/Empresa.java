package model;

import java.util.ArrayList;

public class Empresa {
	
	private String nome;
	private ArrayList<Cliente> listaClientesCadastrados = new ArrayList<Cliente>();
	private ArrayList<Filial> listaFiliaisCadastradas = new ArrayList<Filial>();
	
	public Empresa() {
		this.nome = "Farmácias FGA";
	}

	public String getNome() {
		return nome;
	}

	public ArrayList<Cliente> getListaClientesCadastrados() {
		return listaClientesCadastrados;
	}

	public void setListaClientesCadastrados(ArrayList<Cliente> listaClientesCadastrados) {
		this.listaClientesCadastrados = listaClientesCadastrados;
	}

	public ArrayList<Filial> getListaFiliaisCadastradas() {
		return listaFiliaisCadastradas;
	}

	public void setListaFiliaisCadastradas(ArrayList<Filial> listaFiliaisCadastradas) {
		this.listaFiliaisCadastradas = listaFiliaisCadastradas;
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
