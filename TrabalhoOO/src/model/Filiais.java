package model;

public class Filiais {
	private String cidade;
	private String endereco;
	private int cep;
	
	public Filiais(String cidade, String endereco, int cep) {
		this.cidade = cidade;
		this.endereco = endereco;
		this.cep = cep;
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
	
	public int getCep() {
		return cep;
	}
	
	public void setCep(int cep) {
		this.cep = cep;
	}
	
	public String toString() {
		return "Cidade: " + cidade + ", Endereço: " + endereco +
				   ", CEP: " + cep;
	}			
}