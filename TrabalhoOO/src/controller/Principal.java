package controller;

import view.TelaPrincipal;

/**
 * Classe main do programa em que inicializa o programa
 * @author Caio
 *
 */
public class Principal {
	public static void main(String[] args) {
		
		final ControleCliente cc = new ControleCliente();
		final ControleFilial cf = new ControleFilial();
		final ControleProduto cp = new ControleProduto();
		
		new TelaPrincipal(cc,cf,cp);
	}
	
}
