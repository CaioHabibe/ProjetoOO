package controller;

import java.util.ArrayList;

import model.Filial;

public class ControleFilial {

	private ArrayList <Filial> listaDeFiliais = new ArrayList<Filial>();

	public boolean salvarFilial(String cidade, String endereco, String cnpj) {
			Filial filial = new Filial(cidade, endereco, cnpj);
			listaDeFiliais.add(filial);
			return true;
	}
	
	public ArrayList<Filial> ler() {
		return listaDeFiliais;
	}
	
	public void  remover (String cidade) {
		for (Filial filial : listaDeFiliais) {
			if (filial.getCidade() == cidade) {
				listaDeFiliais.remove(filial);
				break;
			}
		}
	}
	
	public void alterar (Filial filial) {
		for (Filial aux : listaDeFiliais) {
			if (aux.getCidade() == filial.getCidade()) {
				listaDeFiliais.remove(aux);
				listaDeFiliais.add(filial);
				break;
			}
		}
	}
	
}
