package control;

import view.TelaBoasVindas;
import model.Cliente;

public class Principal {
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente("calvo", 123456);
		Cliente cliente2 = new Cliente("lucas", 8756215);
		Cliente cliente3= new Cliente("pedro", 36874);
		
		ControleCliente cc = new ControleCliente();
		System.out.println(cc.salvarCliente(cliente));
		System.out.println(cc.salvarCliente(cliente2));
		System.out.println(cc.salvarCliente(cliente3));
		
		
		
//		TelaBoasVindas telaBoasVindas = new TelaBoasVindas();
//        telaBoasVindas.initialize();
		
//		TelaPrincipal telaPrincipal = new TelaPrincipal();
//        telaPrincipal.initialize();
        
//		ListagemDeCliente telaListagemClientes = new ListagemDeCliente();
//        telaListagemClientes.initialize();
	}
}
