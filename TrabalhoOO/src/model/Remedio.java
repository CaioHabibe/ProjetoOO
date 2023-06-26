package model;

public class Remedio extends Produto{
	
	private String dosagem;
	private String formula;
	private String administracao;

	public Remedio(String nome, Double preco, String descricao, String dosagem, String formula, String administracao) {
		super(nome, preco, descricao);
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

}
