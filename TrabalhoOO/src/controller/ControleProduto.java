package controller;

import model.Cosmetico;
import model.Filial;
import model.Remedio;

public class ControleProduto {
	
    static final Filial filial = new Filial();

    public boolean salvarCosmetico(String nome, Double preco, String descricao, String textura, String fragrancia, String corante, String tipo) {
        	Cosmetico cosmetico = new Cosmetico(nome, preco, descricao, textura, fragrancia, corante, tipo);
        	filial.getListaCosmeticosCadastrados().add(cosmetico);
        	return true;
    }

    public boolean salvarRemedio(String nome, Double preco, String descricao, String dosagem, String formula, String administracao, String tipo) {
    		Remedio remedio = new Remedio(nome, preco, descricao, dosagem, formula, administracao, tipo);
    		filial.getListaRemediosCadastrados().add(remedio);
    		return true;
    }

    public String[][] lerRemedio() {
        final var dados = new String[filial.getListaRemediosCadastrados().size()][];
        for (int i = 0; i < filial.getListaRemediosCadastrados().size(); i++) {
        	dados[i] =filial.getListaRemediosCadastrados().get(i).remedioJtableStruct();
        }
        return dados;
    }
    
    public String[][] lerCosmetico() {
        final var dados = new String[filial.getListaCosmeticosCadastrados().size()][];
        for (int i = 0; i < filial.getListaCosmeticosCadastrados().size(); i++) {
        	dados[i] = filial.getListaCosmeticosCadastrados().get(i).cosmeticoJtableStruct();
        }
        return dados;
    }
    
    public String[][] lerProduto() {
        final var dados = new String[filial.getListaRemediosCadastrados().size()][];
        final var dados2 = new String[filial.getListaCosmeticosCadastrados().size()][];
        final int colunas = 6;

        for (int i = 0; i < filial.getListaRemediosCadastrados().size(); i++) {
            dados[i] = filial.getListaRemediosCadastrados().get(i).remedioJtableStruct();
            }
        for (int i = 0; i < filial.getListaCosmeticosCadastrados().size(); i++) {
            dados2[i] = filial.getListaCosmeticosCadastrados().get(i).cosmeticoJtableStruct();
        }

        final int linhas1 = dados.length;
        final int linhas2 = dados2.length;

        final var array = new String[linhas1 + linhas2][colunas];

        System.arraycopy(dados, 0, array, 0, linhas1);

        System.arraycopy(dados2, 0, array, linhas1, linhas2);

        return array;
    }

    public boolean removerRemedio(int index) {
    	filial.getListaRemediosCadastrados().remove(index);
    	return true;
    }
    
    public boolean removerCosmetico(int index) {
    	filial.getListaCosmeticosCadastrados().remove(index);
    	return true;
    }

    public boolean atualizarRemedio(String nome, Double preco, String descricao, String dosagem, String formula, String administracao, int index) {
    	
    	if (filial.getListaRemediosCadastrados().get(index).getNome() != nome) {
    		filial.getListaRemediosCadastrados().get(index).setNome(nome);
    		return true;
		}	
    	
		if (Double.valueOf(filial.getListaRemediosCadastrados().get(index).getPreco()) != preco) {
			filial.getListaRemediosCadastrados().get(index).setPreco(preco);
			return true;
		}
		if (filial.getListaRemediosCadastrados().get(index).getDescricao() != descricao) {
			filial.getListaRemediosCadastrados().get(index).setDescricao(descricao);
			return true;
		}
		
		if (filial.getListaRemediosCadastrados().get(index).getDosagem() != dosagem) {
			filial.getListaRemediosCadastrados().get(index).setDosagem(dosagem);
			return true;
		}
		
		if (filial.getListaRemediosCadastrados().get(index).getFormula() != formula) {
			filial.getListaRemediosCadastrados().get(index).setFormula(formula);
			return true;
		}
		
		if (filial.getListaRemediosCadastrados().get(index).getAdministracao() != administracao) {
			filial.getListaRemediosCadastrados().get(index).setAdministracao(administracao);
			return true;
		}
		return false;
    }
    
public boolean atualizarCosmetico(String nome, Double preco, String descricao, String textura, String fragrancia, String corante, int index) {
    	
    	if (filial.getListaCosmeticosCadastrados().get(index).getNome() != nome) {
    		filial.getListaCosmeticosCadastrados().get(index).setNome(nome);
    		return true;
		}	
    	
		if (Double.valueOf(filial.getListaCosmeticosCadastrados().get(index).getPreco()) != preco) {
			filial.getListaCosmeticosCadastrados().get(index).setPreco(preco);
			return true;
		}
		if (filial.getListaCosmeticosCadastrados().get(index).getDescricao() != descricao) {
			filial.getListaCosmeticosCadastrados().get(index).setDescricao(descricao);
			return true;
		}
		
		if (filial.getListaCosmeticosCadastrados().get(index).getTextura() != textura) {
			filial.getListaCosmeticosCadastrados().get(index).setTextura(textura);
			return true;
		}
		
		if (filial.getListaCosmeticosCadastrados().get(index).getFragrancia() != fragrancia) {
			filial.getListaCosmeticosCadastrados().get(index).setFragrancia(fragrancia);
			return true;
		}
		
		if (filial.getListaCosmeticosCadastrados().get(index).getCorante() != corante) {
			filial.getListaCosmeticosCadastrados().get(index).setCorante(corante);
			return true;
		}
		return false;
    }
    
}