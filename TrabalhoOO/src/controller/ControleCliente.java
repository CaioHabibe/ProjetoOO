package controller;

import java.util.ArrayList;

import model.Cliente;
import model.Empresa;

public class ControleCliente {
	Empresa empresa = new Empresa();

	public Integer quantidadeClientes() {
		return empresa.getListaClientesCadastrados().size();
	}
	
    public void salvarCliente(String nome, String cpf, String idade) {
            Cliente cliente = new Cliente(nome, cpf, idade);
            empresa.addCliente(cliente);
    }
    
    public ArrayList<Cliente> lerCliente() {
//    	Object row[] = new Object[3];
//    	for (int i=0; i < lista.size(); i++) {
//    		for (Cliente cliente : lista) {
//        		row [0] = lista.get(i).getNome();
//        		row [1] = lista.get(i).getCpf();
//        		row [2] = lista.get(i).getIdade();
//    		}
//    	}
		return empresa.getListaClientesCadastrados();
    }

    public void removerCliente(Integer indexLinha) {
        empresa.removeCliente(empresa.getListaClientesCadastrados().get(indexLinha));
    }

    public void atualizarCliente(String nome, String cpf, String idade) {
        for (Cliente c : empresa.getListaClientesCadastrados()) {
        	if (c.getNome() != nome) {
				c.setNome(nome);
			}	
			if (c.getCpf() != cpf) {
				c.setCpf(cpf);
			}
			if (c.getIdade() != idade) {
				c.setIdade(idade);
			}
        }
    }
    
    public void teste() {
    	for (Cliente cliente : empresa.getListaClientesCadastrados()) {
        	System.out.println(cliente.getNome());
    	}
    }
}