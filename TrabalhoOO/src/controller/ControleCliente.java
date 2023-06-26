package controller;

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
    
    public String[] lerCliente() {
    	String conteudoLinha[] = new String[3];
    	for (Cliente cliente : empresa.getListaClientesCadastrados()) {
			conteudoLinha[0] = cliente.getNome();
			conteudoLinha[1] = cliente.getCpf();
			conteudoLinha[2] = cliente.getIdade();
    	}
    	return conteudoLinha;
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
}