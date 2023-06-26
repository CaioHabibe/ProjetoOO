package controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Cliente;
import model.Filial;

public class ControleFilial {

	private ArrayList <Filial> listaDeFiliais = new ArrayList<Filial>();

	public void salvarFilial(String cidade, String endereco, String cnpj) {
			Filial filial = new Filial(cidade, endereco, cnpj);
			listaDeFiliais.add(filial);
	}
	
	public String ler() {
		return listaDeFiliais.toString();
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
