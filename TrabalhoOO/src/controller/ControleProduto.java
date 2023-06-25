package controller;

import java.util.ArrayList;

import model.Cosmetico;
import model.Produto;
import model.Remedio;

public class ControleProduto {
	
	private ArrayList <Produto> listaDeProdutos = new ArrayList<Produto>();

//	public boolean salvarProduto(String tipo, String nome, double preco, String descricao, long id) {
//		if (validarTipoProduto(tipo) && validarProduto(nome, preco, descricao, id)) {
//			if (tipo == "Remedio") {
//				Remedio remedio = new Remedio(nome, preco, descricao, id);
//			}
//			
//			if (tipo == "Cosmetico") {
//				Cosmetico cosmetico = new Cosmetico(nome, preco, descricao, id);
//			}
//			
//			return true;
//		} else {
//			return false;
//		}
//	}
	
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
