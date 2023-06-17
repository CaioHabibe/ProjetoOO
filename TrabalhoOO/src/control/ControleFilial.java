package control;

import java.util.ArrayList;
import model.Filial;

public class ControleFilial {

	private ArrayList <Filial> listaDeFiliais = new ArrayList<Filial>();

	public boolean salvarCliente(Filial filial) {
		if (filial != null) {
			listaDeFiliais.add(filial);
			return true;
		} else {
			return false;
		}
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
