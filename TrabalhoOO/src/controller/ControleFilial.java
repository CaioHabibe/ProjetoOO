package controller;

import model.Filial;
import model.Empresa;

public class ControleFilial {
	
	static final Empresa empresa = new Empresa();
	
	public ControleFilial(){
        empresa.dadosAleatoriosFilial();
    }
	
	public void salvarFilial(String cidade, String endereco, long cnpj) {
        Filial filial = new Filial(cidade, endereco, cnpj);
        empresa.getListaFiliaisCadastradas().add(filial);
    }

    public String[][] lerFilial() {
        final var dados = new String[empresa.getListaFiliaisCadastradas().size()][];
        for (int i = 0; i < empresa.getListaFiliaisCadastradas().size(); i++) {
        	dados[i] = empresa.getListaFiliaisCadastradas().get(i).filialJtableStruct();
        }
        return dados;
    }

    public void removerFilial(int index) {
    	empresa.getListaFiliaisCadastradas().remove(index);
    }

    public void atualizarFilial(String cidade, String endereco, long cnpj, int index) {
    	
        	if (empresa.getListaFiliaisCadastradas().get(index).getCidade() != cidade) {
        		empresa.getListaFiliaisCadastradas().get(index).setCidade(cidade);
			}	
        	
			if (empresa.getListaFiliaisCadastradas().get(index).getEndereco() != endereco) {
				empresa.getListaFiliaisCadastradas().get(index).setEndereco(endereco);
			}
			if (Long.valueOf(empresa.getListaFiliaisCadastradas().get(index).getCnpj()) != cnpj) {
				empresa.getListaFiliaisCadastradas().get(index).setCnpj(cnpj);
			}
    }
}
