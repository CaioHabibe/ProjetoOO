package model;

import java.util.ArrayList;

public class Cliente {
	
	private ArrayList<String> listaComprasEfetuadas = new ArrayList<String>();
    private String nome;
    private long cpf;
    private int idade;

    public Cliente() {
    }
    
    public Cliente(String nome, long cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public ArrayList<String> getListaComprasEfetuadas() {
		return listaComprasEfetuadas;
	}

	public void setListaComprasEfetuadas(ArrayList<String> listaComprasEfetuadas) {
		this.listaComprasEfetuadas = listaComprasEfetuadas;
	}

	public String[] clienteJtableStruct() {
        return new String[]{nome, String.valueOf(cpf), String.valueOf(idade)};
    }
	
	public String[] comprastableStruct() {
        return new String[]{};
    }
    
//    public ArrayList<Produto> listagemProdutosComprados(){
//    	ArrayList<Produto> aux = new ArrayList<>();
//    	for (Carrinho c : listaComprasEfetuadas) {
//    		aux.addAll(c.listaProdutosCarrinho);
//    	}
//    	return aux;
//    }

}