package controller;

import model.Empresa;
import model.Filial;

public class ControleFilial {
	private Empresa empresa = new Empresa();
	
	public Integer quantidadeFiliais() {
		return empresa.getListaFiliaisCadastradas().size();
	}
	
	public void salvarFilial(String cidade, String endereco, String cnpj) {
			Filial filial = new Filial(cidade, endereco, cnpj);
//			empresa.setListaClientesCadastrados(filial);
	}
	
	public String[] lerFilial() {
		String a[] = new String[3];
		for (Filial filial : empresa.getListaFiliaisCadastradas()) {
			a[0] = filial.getCidade();
			a[1] = filial.getEndereco();
			a[2] = filial.getCnpj();
		}
		return a;
	}
	
	public void removerFilial(Integer indexLinha) {
//		empresa.removeFilial(empresa.getListaFiliaisCadastradas().get(indexLinha));
	}
	
	public void atualizarFilial(String cidade, String endereco, String cnpj) {
		for (Filial f : empresa.getListaFiliaisCadastradas()) {
			if (f.getCidade() != cidade) {
				f.setCidade(cidade);
			}	
			if (f.getEndereco() != endereco) {
				f.setEndereco(endereco);
			}
			if (f.getCnpj() != cnpj) {
				f.setCnpj(cnpj);
			}
		}
	}
}
