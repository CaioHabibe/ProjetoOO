package model;

public class Filial {
	
	private String cidade;
	private String endereco;
	
	public Filial(String cidade, String endereco) {
		this.cidade = cidade;
		this.endereco = endereco;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
