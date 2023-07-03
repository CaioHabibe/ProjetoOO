package controller;

import java.util.ArrayList;

import model.Cliente;
import model.Empresa;

public class ControleCliente {

    static final Empresa empresa = new Empresa();
	
    public boolean salvarCliente(String nome, long cpf, int idade) {
        Cliente cliente = new Cliente(nome, cpf, idade);
        empresa.getListaClientesCadastrados().add(cliente);
        return true;
    }

    public String[][] lerCliente() {
        final var dados = new String[empresa.getListaClientesCadastrados().size()][];
        for (int i = 0; i < empresa.getListaClientesCadastrados().size(); i++) {
        	dados[i] = empresa.getListaClientesCadastrados().get(i).clienteJtableStruct();
        }
        return dados;
    }
    
    public String[] lerCpf() {
    	final var dados = new String[empresa.getListaClientesCadastrados().size()];
        for (int i = 0; i < empresa.getListaClientesCadastrados().size(); i++) {
        	dados[i] = String.valueOf(empresa.getListaClientesCadastrados().get(i).getCpf());
        }
        return dados;
    }
    
    public boolean compra(long cpf, ArrayList<String> compra) {
    	for (int i = 0; i < empresa.getListaClientesCadastrados().size(); i++) {
        	 if (cpf == empresa.getListaClientesCadastrados().get(i).getCpf()){
        		 empresa.getListaClientesCadastrados().get(i).setListaComprasEfetuadas(compra);
        		 return true;
        	 }
        }
    	return false;
    }
    
    public String[][] lerCompra(int a) {
    	final var dados = new String[empresa.getListaClientesCadastrados().size()][];
        for (int i = 0; i < empresa.getListaClientesCadastrados().size(); i++) {
        	dados[i] = empresa.getListaClientesCadastrados().get(a).compraJtableStruct();
        }
        return dados;
    }

    public boolean removerCliente(int index) {
    	empresa.getListaClientesCadastrados().remove(index);
    	return true;
    }

    public boolean atualizarCliente(String nome, long cpf, int idade, int index) {
    	
        	if (empresa.getListaClientesCadastrados().get(index).getNome() != nome) {
        		empresa.getListaClientesCadastrados().get(index).setNome(nome);
        		return true;
			}	
        	
			if (Long.valueOf(empresa.getListaClientesCadastrados().get(index).getCpf()) != cpf) {
				empresa.getListaClientesCadastrados().get(index).setCpf(cpf);
				return true;
			}
			if (Integer.valueOf(empresa.getListaClientesCadastrados().get(index).getIdade()) != idade) {
				empresa.getListaClientesCadastrados().get(index).setIdade(idade);
				return true;
			}
			return false;
    }
}