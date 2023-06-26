package controller;

import model.Cliente;
import model.Empresa;

public class ControleCliente {
	Empresa empresa = new Empresa();
    //private ArrayList <Cliente> listaDeClientes = new ArrayList<Cliente>();

	public Integer quantidadeClientes() {
		return empresa.getListaClientesCadastrados().size();
	}
	
    public void salvarCliente(String nome, String cpf, Integer idade) {
            Cliente cliente = new Cliente(nome, cpf, idade);
            empresa.addCliente(cliente);
            //listaDeClientes.add(cliente);
    }
    
    public Object[] lerCliente() {
    	Object conteudoLinha[] = new Object[3];
    	for (Cliente cliente : empresa.getListaClientesCadastrados()) {
			conteudoLinha[0] = cliente.getNome();
			conteudoLinha[1] = cliente.getCpf();
			conteudoLinha[2] = cliente.getIdade();
    	}
    	return conteudoLinha;
    }

<<<<<<< HEAD
    public void removerCliente(Integer indexLinha) {
        empresa.removeCliente(empresa.getListaClientesCadastrados().get(indexLinha));
=======
    public Object[] ler() {
    	Object conteudoLinha[] = new Object[3];
    	for (Cliente cliente : listaDeClientes) {
			conteudoLinha[0] = cliente.getNome();
			conteudoLinha[1] = cliente.getCpf();
			conteudoLinha[2] = cliente.getIdade();
    	}
    	return conteudoLinha;
>>>>>>> 10a9d7096577110f515cbad6387066e26922c73f
    }

    public void atualizarCliente(String nome, String cpf, Integer idade) {
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