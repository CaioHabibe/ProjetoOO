package model;

/**
 * Classe Cosmetico serve de modelo para um Cosmetico que herda da classe abstrata Produto.
 * @author Caio
 * @since 2023
 */
public class Cosmetico extends Produto {
	
	private String textura;
	private String fragrancia;
	private String corante;
	private String tipo;
	
	/**
	 * Construtora da classe Cosmetico.
	 * @param nome
	 * @param preco
	 * @param descricao
	 * @param textura
	 * @param fragrancia
	 * @param corante
	 * @param tipo
	 */
	public Cosmetico(String nome, double preco, String descricao, String textura, String fragrancia, String corante, String tipo) {
		super(nome, preco, descricao);
		this.corante = corante;
		this.fragrancia = fragrancia;
		this.textura = textura;
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
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
	
	/**
	 * Metodo que retorna os dados de um Cosmetico em forma de array.
	 * @return String[]
	 */
	public String[] cosmeticoJtableStruct() {
        return new String[]{nome, String.valueOf(preco), descricao, textura, fragrancia, corante};
    }
	
}
