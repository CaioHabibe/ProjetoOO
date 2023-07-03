package model;

import java.util.ArrayList;
/**
 * Classe Filial que representa o modelo de uma Filial.
 * @author Caio
 * @since 2023
 */
public class Filial {
	
	private ArrayList<Remedio> listaRemediosCadastrados = new ArrayList<Remedio>();
	private ArrayList<Cosmetico> listaCosmeticosCadastrados = new ArrayList<Cosmetico>();
	
	private String cidade;
	private String endereco;
	private long cnpj;
	
	/**
	 * Construtor da classe Filial.
	 */
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
	
	/**
	 * Metodo em que retorna os dados de uma filial em forma de array.
	 * @return String[]
	 */
	public String[] filialJtableStruct() {
        return new String[]{cidade, endereco, String.valueOf(cnpj)};
    }

	public void dadosAleatoriosRemedio() {
        for (int i = 1; i <= 3; i++) {
            Remedio remedio = new Remedio("Remedio" + i, 10.00*i, "Nivel de dor " + i,"Mg" + i, 
                    "Formula " + i, "Injeção " + i, "Remedio");
            listaRemediosCadastrados.add(remedio);
        }
    }
	public void dadosAleatoriosCosmetico() {
        for (int i = 1; i <= 3; i++) {
            Cosmetico cosmetico = new Cosmetico("Remedio" + i, 10.00*i, "Nivel de dor " + i,"Mg" + i, 
                    "Formula " + i, "Injeção " + i, "Remedio");
            listaCosmeticosCadastrados.add(cosmetico);
        }
    }
}

