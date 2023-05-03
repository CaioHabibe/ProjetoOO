package model;

public class Remedio extends Produto{
	private String dosagem;
	
	public Remedio(int identificacao, String nome, String marca, double preco, String descricao, int qtd,
			String dosagem) {
		super(identificacao, nome, marca, preco, descricao, qtd);
		this.dosagem = dosagem;
	}

	public String getDosagem() {
		return dosagem;
	}
	
	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}
	
	public String toString() {
		return "Id: " + id + ", Nome: " + nome +
				   ", Marca: " + marca +", Preço: "+ preco +", Descrição: "+ descricao +", Quantidade: "+ qtd +","
				   		+" Dosagem: "+ dosagem;
	}
}