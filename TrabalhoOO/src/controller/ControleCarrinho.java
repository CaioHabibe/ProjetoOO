package controller;

import java.util.ArrayList;

import model.Cliente;

public class ControleCarrinho {
	
	static final Cliente cliente = new Cliente();
	
	public void salvarCompra(ArrayList<String> compras) {
        cliente.setListaComprasEfetuadas(compras);
    }

    public String[][] LerCompra() {
        final var dados = new String[cliente.getListaComprasEfetuadas().size()][];
        for (int i = 0; i < cliente.getListaComprasEfetuadas().size(); i++) {
//        	dados[i] = cliente.getListaComprasEfetuadas().get(i).comprasJtableStruct();
        }
        return dados;
    }
   
}
