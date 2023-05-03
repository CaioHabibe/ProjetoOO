package model;

public class Beleza extends Produto {
	private boolean PresencaPerfume;
	
	public Beleza(int id, String nome, String marca, double preco, String descricao,
				   int qtd, boolean PresencaPerfume) {
		 super(id, nome, marca, preco, descricao, qtd);
		 this.PresencaPerfume = PresencaPerfume;
	}
	
	public boolean getPresencaPerfume() {
		return PresencaPerfume;
	}
	
	public void setPresencaPerfume(boolean presencaPerfume) {
		this.PresencaPerfume = presencaPerfume;	
	}
	public String toString() {
		return "Id: " + id + ", Nome: " + nome +
				   ", Marca: " + marca +", Preço: "+ preco +", Descrição: "+ descricao +", Quantidade: "+ qtd +
				   ", Presença de perfume: "+ PresencaPerfume;
	}
}