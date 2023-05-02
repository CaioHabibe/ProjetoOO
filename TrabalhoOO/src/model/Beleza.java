package model;

public class Beleza extends Produto {
	private boolean presencaPerfume;
	
	public Beleza(int id, String nome, String marca, double preco, String descricao,
				   int qtd, boolean presencaPerfume) {
		 super(id, nome, marca, preco, descricao, qtd);
		 this.presencaPerfume = presencaPerfume;
	}
	
	public boolean getPresencaPerfume() {
		return presencaPerfume;
	}
	
	public void setPresencaPerfume(boolean presencaPerfume) {
		this.presencaPerfume = presencaPerfume;	
	}
	
}