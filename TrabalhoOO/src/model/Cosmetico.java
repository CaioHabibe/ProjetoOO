package model;

public class Cosmetico extends Produto {
	
	private String textura;
	private String fragrancia;
	private boolean corante;
	
	public Cosmetico(String nome, double preco, String descricao, String textura, String fragrancia, boolean corante) {
		super(nome, preco, descricao);
		this.textura = textura;
		this.fragrancia = fragrancia;
		this.corante = corante;
	}
		
	public Cosmetico(String nome, double preco, String descricao) {
		super(nome, preco, descricao);
		// TODO Auto-generated constructor stub
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

	public boolean isCorante() {
		return corante;
	}

	public void setCorante(boolean corante) {
		this.corante = corante;
	}
	
}
