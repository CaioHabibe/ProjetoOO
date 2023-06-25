package model;

public class Filial {
	private String cidade;
	private String endereco;
	private String cnpj;
	
	public Filial() {}

	public Filial(String cidade, String endereco, String cnpj) {
		this.cidade = cidade;
		this.endereco = endereco;
		this.cnpj = cnpj;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
}
