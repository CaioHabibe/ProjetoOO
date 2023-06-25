package controller;

import java.util.ArrayList;

import model.Cliente;

public class ControleCliente {
	
	private ArrayList <Cliente> listaDeClientes = new ArrayList<Cliente>();

	public void salvarCliente(Cliente cliente) {
			listaDeClientes.add(cliente);
	}
	
	public ArrayList<Cliente> ler() {
		return listaDeClientes;
	}
	
	public void  remover (String cpf) {
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
