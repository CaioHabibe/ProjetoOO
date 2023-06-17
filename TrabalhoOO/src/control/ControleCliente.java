package control;

import java.util.ArrayList;
import model.Cliente;

public class ControleCliente {
	
	private ArrayList <Cliente> listaDeClientes = new ArrayList<Cliente>();

	public boolean salvarCliente(Cliente cliente) {
		if (cliente != null) {
			listaDeClientes.add(cliente);
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<Cliente> ler() {
		return listaDeClientes;
	}
	
	public void  remover (long cpf) {
		for (Cliente cliente : listaDeClientes) {
			if (cliente.getCpf() == cpf) {
				listaDeClientes.remove(cliente);
				break;
			}
		}
	}
	
	public void alterar (Cliente cliente) {
		for (Cliente aux : listaDeClientes) {
			if (aux.getCpf() == cliente.getCpf()) {
				listaDeClientes.remove(aux);
				listaDeClientes.add(cliente);
				break;
	}
		}
	}
}
