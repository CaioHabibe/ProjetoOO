package control;

import java.util.ArrayList;
import model.Cliente;

public class ControleCliente {
	
	private ArrayList <Cliente> listaDeClientes = new ArrayList<Cliente>();

	//Método responsável por salvar o cliente
//	public boolean salvarCliente(Cliente cliente) {
//		if (cliente != null) {
//			listaDeClientes.add(cliente);
//			return true;
//		} else {
//			return false;
//		}
//	}
	
	//Outra opção para o método salvarCliente
	public boolean salvarCliente(String nome, String cpf) {
		if (validarNome(nome) && validarCPF(cpf)) {
			Cliente cliente = new Cliente(nome, cpf);
			cliente.cadastrarCliente();
			return true;
		}
		return false;
	}
	
	/* método validarCPF
	 * O método validarCPF recebe uma String como parâmetro e retorna um valor booleano.
	 * É utilizado o método matches, pois este
	 * especifica uma expressão regular e localiza o conteúdo do objeto String 
	 * em que está sendo aplicada essa expressão e, para saber
	 * se a expressão foi atendida, usa-se como retorno um valor booleano
	 * */
	public static boolean validarCPF(String cpf) {
		if(cpf.matches("[0-9]+")) {
			return true;
		}
		return false;
	}
	
	/*
	 * método validarNome
	 * */
	public static boolean validarNome(String nome) {
		if(nome != null && nome.length() > 0) {
			return true;
		}
		return false;
	}
	
	//Método responsável por mostrar os clientes 
	public ArrayList<Cliente> ler() {
		return listaDeClientes;
	}
	
	
	//Método responsável por remover o Cliente por CPF
	public void  remover (String cpf) {
		for (Cliente cliente : listaDeClientes) {
			if (cliente.getCpf() == cpf) {
				listaDeClientes.remove(cliente);
				break;
			}
		}
	}
	
	
	//Método responsável por alterar informações do cliente
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
