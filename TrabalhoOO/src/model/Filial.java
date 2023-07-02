package model;

import java.util.ArrayList;

public class Filial {
	
	private ArrayList<Remedio> listaRemediosCadastrados = new ArrayList<Remedio>();
	private ArrayList<Cosmetico> listaCosmeticosCadastrados = new ArrayList<Cosmetico>();
	
	private String cidade;
	private String endereco;
	private long cnpj;

	public Filial() {
	}

	public Filial(String cidade, String endereco, long cnpj) {
		this.cidade = cidade;
		this.endereco = endereco;
		this.cnpj = cnpj;
	}
	
	public ArrayList<Remedio> getListaRemediosCadastrados() {
		return listaRemediosCadastrados;
	}

	public void setListaRemediosCadastrados(ArrayList<Remedio> listaRemediosCadastrados) {
		this.listaRemediosCadastrados = listaRemediosCadastrados;
	}

	public ArrayList<Cosmetico> getListaCosmeticosCadastrados() {
		return listaCosmeticosCadastrados;
	}

	public void setListaCosmeticosCadastrados(ArrayList<Cosmetico> listaCosmeticosCadastrados) {
		this.listaCosmeticosCadastrados = listaCosmeticosCadastrados;
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

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public String[] filialJtableStruct() {
        return new String[]{cidade, endereco, String.valueOf(cnpj)};
    }
	
}
