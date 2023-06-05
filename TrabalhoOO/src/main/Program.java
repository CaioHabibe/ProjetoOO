package main;

import java.util.Scanner;

import model.Beleza;
import model.Remedio;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//testes básicos para o funcionamento do código
		
		System.out.println("DIGITE UMA OPÇÃO");
		System.out.println("1 - ADICIONAR PRODUTO");
		System.out.println("2 - REMOVER PRODUTO");
		System.out.println("3 - ATUALIZAR PRODUTO");
		System.out.println("4 - ADICIONAR FILIAL");
		System.out.println("5 - REMOVER FILIAL");
		System.out.println("6 - ATUALIZAR FILIAL");
		System.out.println("7 - ADICIONAR CLIENTE");
		System.out.println("8 - REMOVER CLIENTE ");
		System.out.println("9 - ATUALIZAR CLIENTE");
		
		int escolha = sc.nextInt();
		
		switch(escolha) {
		case 1:
			System.out.println("Qual tipo de produto você gostaria de adicionar à filial? ");
			System.out.println("1 - Cosmético ");
			System.out.println("2 - Remédio ");
			int tipoProduto = sc.nextInt();
			if(tipoProduto == 1) {
						System.out.print("NOME: ");
						String nome = sc.nextLine();
						sc.next();
						
						System.out.print("MARCA: ");
						String marca = sc.nextLine();
						sc.next();
						
						System.out.print("PRECO: ");
						double preco = sc.nextDouble();
						
						System.out.print("QUANTIDADE: ");
						int qtd = sc.nextInt();
						
						System.out.printf("POSSUI PERFUME [(true) ou (false)]: ");
						boolean presencaPerfume = sc.nextBoolean();
						
						System.out.println("TEXTURA: ");
						String textura = sc.nextLine();
						sc.next();
						
						System.out.print("TIPO DE PELE: ");
						String tipoDePele = sc.nextLine();
						sc.next();
						
						Beleza beleza = new Beleza(nome, marca, preco, qtd, 
										presencaPerfume,textura, tipoDePele);
						System.out.println(beleza.toString());
						
			} else if (tipoProduto == 2) {
						System.out.print("NOME: ");
						String nomeR = sc.nextLine();
						sc.next();
						
						System.out.print("MARCA: ");
						String marcaR = sc.nextLine();
						sc.next();
						
						System.out.print("PRECO: ");
						double precoR = sc.nextDouble();
						
						System.out.print("QUANTIDADE: ");
						int qtdR = sc.nextInt();
						
						System.out.printf("DOSAGEM: ");
						double dosagem = sc.nextDouble();
						
						System.out.print("Formula: ");
						String formula = sc.nextLine();
						sc.next();
						
						System.out.print("Administracao: ");
						String administracao = sc.nextLine();
						sc.next();
						
						Remedio remedio = new Remedio(nomeR, marcaR, precoR, qtdR, 
										dosagem,formula, administracao);
						System.out.println(remedio.toString());		
				} else {
					System.out.println("TIPO DE PRODUTO NÃO EXISTENTE!");
				}
			break;
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		default:
			System.out.println("Nenhuma das escolhas anteriores foi atendida.");
			System.out.println("Fim.");
			break;
		}
		sc.close();
	}
}