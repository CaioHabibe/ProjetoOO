package main;

import model.*;

public class Program {

	public static void main(String[] args) {

		Cliente cliente = new Cliente("Masculino", 61444444, 12345, 19, "Junior");
		System.out.println(cliente.toString());
		cliente.setNome("Pedro");
		System.out.println(cliente.getNome());
		
		Remedio remedio = new Remedio(69773, "Dipirona", "Genérico", 9.99, "Para dor de cabeça", 21,
				"10 ml");
		System.out.println(remedio.toString());
		remedio.setNome("Novalgina");
		System.out.println(remedio.getNome());
		
		Beleza beleza = new Beleza(58498, "Shampoo", "Pantene", 7.99, "Para cabelos",
				2,	true);
		System.out.println(beleza.toString());
		beleza.setPresencaPerfume(false);
		System.out.println(beleza.getPresencaPerfume());
		
		Filiais filiais = new Filiais("Brasília", "Sqsw 100", 99999999);
		System.out.println(filiais.toString());
		filiais.setCidade("Santa Catarina");
		System.out.println(filiais.getCidade());
	}
}