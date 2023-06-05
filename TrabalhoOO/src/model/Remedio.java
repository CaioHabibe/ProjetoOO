package model;

public class Remedio extends Produto{
	private double dosagem;
	private String formula;
	private String administracao;
	
	public Remedio(String nome, String marca, double preco, int qtd,
			double dosagem, String formula, String administracao) {
		super(nome, marca, preco, qtd);
		this.dosagem = dosagem;
		this.formula = formula;
		this.administracao = administracao;
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

	@Override
	public String toString() {
		return "Produto [Remedio [nome=" + nome + ""
				+ ", marca=" + marca + ","
				+ ", preco=" + preco + ","
				+ " qtd=" + qtd + ","
				+ " dosagem=" + dosagem + " mg,"
				+ " formula=" + formula + ","
				+ " administracao=" + administracao + 
				"]]";
	}
	
	
}