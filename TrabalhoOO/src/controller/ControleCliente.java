package controller;

import java.util.ArrayList;

import model.Cliente;
import model.Empresa;

/**
 * Classe ControleCliente serve de controladora de dados do tipo Cliente, no modelo MVC.
 * @author Caio
 *
 */
public class ControleCliente {

    static final Empresa empresa = new Empresa();
	
    /**
     * Construtora da classe.
     */
    public ControleCliente() {
        empresa.dadosAleatoriosCliente();
    }
    
    /**
     * Metodo de salvar Cliente
     * @param nome
     * @param cpf
     * @param idade
     * @return
     */
    public boolean salvarCliente(String nome, long cpf, int idade) {
        Cliente cliente = new Cliente(nome, cpf, idade);
        empresa.getListaClientesCadastrados().add(cliente);
        return true;
    }
    
    /**
     * Metodo de ler Cliente
     * @return String[][]
     */
    public String[][] lerCliente() {
        final var dados = new String[empresa.getListaClientesCadastrados().size()][];
        for (int i = 0; i < empresa.getListaClientesCadastrados().size(); i++) {
        	dados[i] = empresa.getListaClientesCadastrados().get(i).clienteJtableStruct();
        }
        return dados;
    }
    
    /**
     * Metodo de ler o dado CPF do cliente
     * @return String[]
     */
    public String[] lerCpf() {
    	final var dados = new String[empresa.getListaClientesCadastrados().size()];
        for (int i = 0; i < empresa.getListaClientesCadastrados().size(); i++) {
        	dados[i] = String.valueOf(empresa.getListaClientesCadastrados().get(i).getCpf());
        }
        return dados;
    }
    
    /**
     * Metodo de compra de Produto pelo Cliente
     * @param cpf
     * @param compra
     * @return Boolean
     */
    public boolean compra(long cpf, ArrayList<String> compra) {
    	for (int i = 0; i < empresa.getListaClientesCadastrados().size(); i++) {
        	 if (cpf == empresa.getListaClientesCadastrados().get(i).getCpf()){
        		 empresa.getListaClientesCadastrados().get(i).setListaComprasEfetuadas(compra);
        		 return true;
        	 }
        }
    	return false;
    }
    
    /**
     * Metodo de leitura de compra
     * @param a
     * @returnObject[]
     */
    public Object[] lerCompra(int a) {
        return empresa.getListaClientesCadastrados().get(a).compraJtableStruct();
    }
    
    /**
     * Metodo de remover Cliente
     * @param index
     * @return Boolean
     */
    public boolean removerCliente(int index) {
    	empresa.getListaClientesCadastrados().remove(index);
    	return true;
    }
    
    /**
     * Metodo de atualizar dados do Cliente
     * @param nome
     * @param cpf
     * @param idade
     * @param index
     * @return Boolean
     */
    public boolean atualizarCliente(String nome, long cpf, int idade, int index) {
    	
        	if (empresa.getListaClientesCadastrados().get(index).getNome() != nome) {
        		empresa.getListaClientesCadastrados().get(index).setNome(nome);
        		return true;
			}	
        	
			if (Long.valueOf(empresa.getListaClientesCadastrados().get(index).getCpf()) != cpf) {
				empresa.getListaClientesCadastrados().get(index).setCpf(cpf);
				return true;
			}
			if (Integer.valueOf(empresa.getListaClientesCadastrados().get(index).getIdade()) != idade) {
				empresa.getListaClientesCadastrados().get(index).setIdade(idade);
				return true;
			}
			return false;
    }
}