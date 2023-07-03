package model;

/**
 * Classe Remedio representa a modelo de uma remedio e herda da Classe abstrata Produto.
 * @author Caio
 * @since 2023
 */
public class Remedio extends Produto{
	
	private String dosagem;
	private String formula;
	private String administracao;
	private String tipo;
	
	/**
	 * Construtor da classe Remedio.
	 * @param nome
	 * @param preco
	 * @param descricao
	 * @param dosagem
	 * @param formula
	 * @param administracao
	 * @param tipo
	 */
	public Remedio(String nome, Double preco, String descricao, String dosagem, String formula, String administracao, String tipo) {
		super(nome, preco, descricao);
		this.dosagem = dosagem;
		this.formula = formula;
		this.administracao = administracao;
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
	
	public String getDosagem() {
		return dosagem;
	}

	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getAdministracao() {
		return administracao;
	}

	public void setAdministracao(String administracao) {
		this.administracao = administracao;
	}
	
	/**
	 * Retorna todos os dados de um remedio em forma de array.
	 * @return String[]
	 */
    public String[] remedioJtableStruct() {
        return new String[]{nome, String.valueOf(preco), descricao, dosagem, formula, administracao};
    }
}
