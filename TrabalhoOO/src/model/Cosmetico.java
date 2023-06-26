package model;

public class Cosmetico extends Produto {
	
	private String textura;
	private String fragrancia;
	private String corante;
	
	public Cosmetico(String nome, double preco, String descricao) {
		super(nome, preco, descricao);
	}

	public String getTextura() {
		return textura;
	}

	public void setTextura(String textura) {
		this.textura = textura;
	}

	public String getFragrancia() {
		return fragrancia;
	}

	public void setFragrancia(String fragrancia) {
		this.fragrancia = fragrancia;
	}

	public String getCorante() {
		return corante;
	}

	public void setCorante(String corante) {
		this.corante = corante;
	}
	
}
