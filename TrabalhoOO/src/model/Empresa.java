package model;

import java.util.ArrayList;

public class Empresa {
	
	ArrayList<Filial> listaFiliaisCadastradas;
	ArrayList<Cliente> listaClientesCadastrados;
	
	private String nome;
	
	public Empresa() {
		this.nome = "Farmácias FGA";
		listaFiliaisCadastradas = new ArrayList<>();
		listaClientesCadastrados = new ArrayList<>();
	}
	
	public String getNome() {
		return nome;
	}
	
	public ArrayList<Filial> getListaFiliaisCadastradas(){
		return listaFiliaisCadastradas;
	}
	
	public ArrayList<Cliente> getListaClientesCadastrados(){
		return listaClientesCadastrados;
	}
	
	public void addFilial(Filial f) {
		listaFiliaisCadastradas.add(f);
	}
	
	public void removeFilial(Filial f) {
		listaFiliaisCadastradas.remove(f);
	}
	
	public void addCliente(Cliente c) {
		listaClientesCadastrados.add(c);
	}
	
	public void removeCliente(Cliente c) {
		listaClientesCadastrados.remove(c);
	}
	
	public ArrayList<Filial> listagemFilialPorCidade(String cidade){
		ArrayList<Filial> filtro = new ArrayList<>();
		for(Filial filial : listaFiliaisCadastradas) {
			if(filial.getCidade().contains(cidade)) {
				filtro.add(filial);
			}
		}
		return filtro;
	}
	
}
