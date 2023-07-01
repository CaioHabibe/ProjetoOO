package controller;

import java.util.ArrayList;

import model.Cliente;
import model.Empresa;

public class ControleCliente {
	
	static Empresa empresa = new Empresa();
	
    public void salvarCliente(String nome, String cpf, String idade) {
            Cliente cliente = new Cliente(nome, cpf, idade);
            empresa.adicionarCliente(cliente);
            
            }
  
    public ArrayList<Cliente> lerCliente() {
//    	Object[] clientes = null;
//        	for (Cliente cliente : empresa.getListaClientesCadastrados()) {
//        		Object[] clientes1 = {
//        				cliente.getNome(),
//        		};
//        		clientes = clientes1;
//        	}
		return empresa.getListaClientesCadastrados();
    }
//
//    public void removerCliente(Integer indexLinha) {
//    	
//    }
//
//    public void atualizarCliente(String nome, String cpf, String idade) {
//        for (Cliente c : empresa.getListaClientesCadastrados()) {
//        	if (c.getNome() != nome) {
//				c.setNome(nome);
//			}	
//			if (c.getCpf() != cpf) {
//				c.setCpf(cpf);
//			}
//			if (c.getIdade() != idade) {
//				c.setIdade(idade);
//			}
//        }
    }