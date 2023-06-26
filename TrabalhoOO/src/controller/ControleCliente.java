package controller;

import java.util.ArrayList;

import model.Cliente;

public class ControleCliente {

    private ArrayList <Cliente> listaDeClientes = new ArrayList<Cliente>();

    public void salvarCliente(String nome, String cpf, Integer idade) {
            Cliente cliente = new Cliente(nome, cpf, idade);
            listaDeClientes.add(cliente);
    }

    public Object[] ler() {
    	Object conteudoLinha[] = new Object[3];
    	for (Cliente cliente : listaDeClientes) {
			conteudoLinha[0] = cliente.getNome();
			conteudoLinha[1] = cliente.getCpf();
			conteudoLinha[2] = cliente.getIdade();
    	}
    	return conteudoLinha;
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