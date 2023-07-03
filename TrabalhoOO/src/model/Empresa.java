package model;

import java.util.ArrayList;

/**
 * Classe Empresa que faz o gerenciamento de dados do programa. 
 * @author Caio
 * @since 2023
 */
public class Empresa {
	
	private String nome;
	private ArrayList<Cliente> listaClientesCadastrados = new ArrayList<Cliente>();
	private ArrayList<Filial> listaFiliaisCadastradas = new ArrayList<Filial>();
	
	/**
	 * Construtor da classe Empresa.
	 */
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

}
