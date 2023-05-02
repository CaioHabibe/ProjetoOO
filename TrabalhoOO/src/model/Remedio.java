package model;

public class Remedio extends Produto{
	private double dosagem;
	
	public Remedio(int id, String nome, String marca, double preco, String descricao, int qtd
				  , double dosagem) {
		super();
		this.dosagem = dosagem;
	}
	
	public double getDosagem() {
		return dosagem;
	}
	public void setDosagem(double dosagem) {
		this.dosagem = dosagem;
	}
	
	
}