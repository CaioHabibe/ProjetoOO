package main;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Seja bem vindo ao aplicativo de farmácia FGA!");
		System.out.println("Escolha a opção desejada: ");
		System.out.println("1 - Cadastrar cliente. ");
		System.out.println("2 - Cadastrar produto. ");
		int numero = input.nextInt();
		if (numero == 1) {
			System.out.print("Digite o seu nome: ");
			String nome = input.next();
			
			System.out.println();
			System.out.print("Digite o seu telefone: ");
			int telefone = input.nextInt();
			
			System.out.println();
			System.out.print("Digite o seu sexo: ");
			String sexo = input.next();
			
			System.out.println();
			System.out.print("Digite a sua idade:  ");
			int idade = input.nextInt();
			
			System.out.println();
			System.out.print("Digite o seu CPF: ");
			String cpf = input.next();
			
			Cliente cliente = new Cliente(sexo, telefone, cpf, idade, nome);
			System.out.println(cliente.toString());
		} 
		else if (numero == 2) { 
			
		}
		else {
			System.out.println("Obrigado por usar o aplicativo e volte sempre.");
		}
		
		input.close();
	}
}
	