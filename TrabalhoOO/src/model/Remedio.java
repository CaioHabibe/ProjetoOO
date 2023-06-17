package model;

public class Remedio extends Produto{
	
	private double dosagem;
	private String formula;
	private String administracao;

	public Remedio(String nome, double preco, String descricao, long id) {
		super(nome, preco, descricao, id);
		// TODO Auto-generated constructor stub
	}

	public double getDosagem() {
		return dosagem;
	}

	public void setDosagem(double dosagem) {
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
