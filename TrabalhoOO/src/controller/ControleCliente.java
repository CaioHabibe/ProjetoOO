package controller;

import model.Cliente;
import model.Empresa;

public class ControleCliente {

    static final Empresa empresa = new Empresa();
	
    public ControleCliente() {
        empresa.dadosAleatoriosCliente();
    }
    
    public void salvarCliente(String nome, long cpf, int idade) {
        Cliente cliente = new Cliente(nome, cpf, idade);
        empresa.getListaClientesCadastrados().add(cliente);
    }

    public String[][] lerCliente() {
        final var dados = new String[empresa.getListaClientesCadastrados().size()][];
        for (int i = 0; i < empresa.getListaClientesCadastrados().size(); i++) {
        	dados[i] = empresa.getListaClientesCadastrados().get(i).clienteJtableStruct();
        }
        return dados;
    }

    public void removerCliente(int index) {
    	empresa.getListaClientesCadastrados().remove(index);
    }

    public void atualizarCliente(String nome, long cpf, int idade, int index) {
    	
        	if (empresa.getListaClientesCadastrados().get(index).getNome() != nome) {
        		empresa.getListaClientesCadastrados().get(index).setNome(nome);
			}	
        	
			if (Long.valueOf(empresa.getListaClientesCadastrados().get(index).getCpf()) != cpf) {
				empresa.getListaClientesCadastrados().get(index).setCpf(cpf);
			}
			if (Integer.valueOf(empresa.getListaClientesCadastrados().get(index).getIdade()) != idade) {
				empresa.getListaClientesCadastrados().get(index).setIdade(idade);
			}
    }
    
}