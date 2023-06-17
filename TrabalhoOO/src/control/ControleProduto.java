package control;

import java.util.ArrayList;
import model.Produto;

public class ControleProduto {
	
	private ArrayList <Produto> listaDeProdutos = new ArrayList<Produto>();

	public boolean salvarCliente(Produto produto) {
		if (produto != null) {
			listaDeProdutos.add(produto);
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<Produto> ler() {
		return listaDeProdutos;
	}
	
	public void  remover (long id) {
		for (Produto produto : listaDeProdutos) {
			if (produto.getId() == id) {
				listaDeProdutos.remove(produto);
				break;
			}
		}
	}
	
	public void alterar (Produto produto) {
		for (Produto aux : listaDeProdutos) {
			if (aux.getId() == produto.getId()) {
				listaDeProdutos.remove(aux);
				listaDeProdutos.add(produto);
				break;
	}
		}
	}
}
