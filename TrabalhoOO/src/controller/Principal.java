package controller;

import view.TelaPrincipal;

public class Principal {
	public static void main(String[] args) {
		
		ControleCliente cc = new ControleCliente();
		
		new TelaPrincipal(cc);
	}
	
}
