package controller;

import java.util.ArrayList;
import model.Filial;

public class ControleFilial {

	private ArrayList <Filial> listaDeFiliais = new ArrayList<Filial>();

	public boolean salvarFilial(String cidade, String endereco) {
		if (validarCidade(cidade) && validarEndereco(endereco)) {
			Filial filial = new Filial(cidade, endereco);
			filial.cadastrarFilial(filial);
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean validarCidade(String cidade) {
		if(cidade != null && cidade.length() > 0) {
			return true;
		}
		return false;
	}
	
	public static boolean validarEndereco(String endereco) {
		if (endereco != null && endereco.length() > 0) {
			return true;
		}
		return false;
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
