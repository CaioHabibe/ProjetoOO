package controller;

import java.util.ArrayList;

import model.Cosmetico;
import model.Produto;
import model.Remedio;

public class ControleProduto {
	
	private ArrayList <Produto> listaDeProdutos = new ArrayList<Produto>();

	public boolean salvarProduto(String tipo, String nome, double preco, String descricao, long id) {
		if (validarTipoProduto(tipo) && validarProduto(nome, preco, descricao, id)) {
			if (tipo == "Remedio") {
				Remedio remedio = new Remedio(nome, preco, descricao, id);
			}
			
			if (tipo == "Cosmetico") {
				Cosmetico cosmetico = new Cosmetico(nome, preco, descricao, id);
			}
			
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean validarTipoProduto(String tipo) {
		if (tipo != null && tipo.length() > 0 && tipo == "Remedio") {
			return true;
		} 
		
		if (tipo != null && tipo.length() > 0 && tipo == "Cosmetico") {
			return true;
		}
		
		return false;
	}

	public static boolean validarProduto(String nome, double preco, String descricao, long id) {
		if (nome != null && nome.length() > 0 && preco >= 0.0 && descricao != null 
				&& descricao.length() > 0 && id >= 0) {
			return true;
		}
		
		return false;
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
