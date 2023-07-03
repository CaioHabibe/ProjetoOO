package controller;

import model.Filial;
import model.Empresa;

/**
 * Classe ControleFilial serve de controladora de dados do tipo Filial, no modelo MVC.
 * @author Caio
 *
 */
public class ControleFilial {
	
	static final Empresa empresa = new Empresa();
	
	/**
	 * Construtora da classe
	 */
	public ControleFilial(){
        empresa.dadosAleatoriosFilial();
    }
	
	/**
	 * Metodo de salvar Filial
	 * @param cidade
	 * @param endereco
	 * @param cnpj
	 * @return boolean
	 */
	public boolean salvarFilial(String cidade, String endereco, long cnpj) {
        Filial filial = new Filial(cidade, endereco, cnpj);
        empresa.getListaFiliaisCadastradas().add(filial);
        return true;
    }

	/**
	 * Metodo de leitura de Filial
	 * @return String[][]
	 */
    public String[][] lerFilial() {
        final var dados = new String[empresa.getListaFiliaisCadastradas().size()][];
        for (int i = 0; i < empresa.getListaFiliaisCadastradas().size(); i++) {
        	dados[i] = empresa.getListaFiliaisCadastradas().get(i).filialJtableStruct();
        }
        return dados;
    }
    
    /**
     * Metodo de remover Filial
     * @param index
     * @return boolean
     */
    public boolean removerFilial(int index) {
    	empresa.getListaFiliaisCadastradas().remove(index);
    	return true;
    }
    
    /**
     * Metodo de atualizar Filial
     * @param cidade
     * @param endereco
     * @param cnpj
     * @param index
     * @return boolean
     */
    public boolean atualizarFilial(String cidade, String endereco, long cnpj, int index) {
    	
        	if (empresa.getListaFiliaisCadastradas().get(index).getCidade() != cidade) {
        		empresa.getListaFiliaisCadastradas().get(index).setCidade(cidade);
        		return true;
			}	
        	
			if (empresa.getListaFiliaisCadastradas().get(index).getEndereco() != endereco) {
				empresa.getListaFiliaisCadastradas().get(index).setEndereco(endereco);
				return true;
			}
			if (Long.valueOf(empresa.getListaFiliaisCadastradas().get(index).getCnpj()) != cnpj) {
				empresa.getListaFiliaisCadastradas().get(index).setCnpj(cnpj);
				return true;
			}
			return false;
    }
}