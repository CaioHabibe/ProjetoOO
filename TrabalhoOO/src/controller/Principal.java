package controller;

import view.TelaPrincipal;

public class Principal {
	public static void main(String[] args) {
		
		final ControleCliente cc = new ControleCliente();
		final ControleFilial cf = new ControleFilial();
		final ControleProduto cp = new ControleProduto();
		final ControleCarrinho cca = new ControleCarrinho();
		
		new TelaPrincipal(cc,cf,cp,cca);
	}
	
}
