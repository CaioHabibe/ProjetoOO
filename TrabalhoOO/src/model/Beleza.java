package model;

public class Beleza extends Produto {
	private boolean presencaPerfume;
	private String textura;
	private String tipoDePele;
	
	public Beleza() {};
	public Beleza(String nome, String marca, double preco,
				   int qtd, boolean presencaPerfume,String textura, String tipoDePele) {
		 super(nome, marca, preco, qtd);
		 this.presencaPerfume = presencaPerfume;
		 this.textura = textura;
		 this.tipoDePele = tipoDePele;
	}
	
	public boolean getPresencaPerfume() {
		return presencaPerfume;
	}
	
	public void setPresencaPerfume(boolean presencaPerfume) {
		this.presencaPerfume = presencaPerfume;	
	}
	
	public String getTextura() {
		return textura;
	}

	public void setTextura(String textura) {
		this.textura = textura;
	}

	public String getTipoDePele() {
		return tipoDePele;
	}

	public void setTipoDePele(String tipoDePele) {
		this.tipoDePele = tipoDePele;
	}

	public String toString() {
		return "Produto [Beleza [nome=" + nome + ""
				+ ", marca=" + marca + ""
				+ ", preco=" + preco + ","
				+ " qtd=" + qtd + ","
				+ " presenca de Perfume=" + presencaPerfume + ","
				+ " textura=" + textura + ","
				+ " tipoDePele=" + tipoDePele + 
				"]]";
	}
}