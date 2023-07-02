package model;

import java.util.ArrayList;

public class Cliente {
	
	ArrayList<Carrinho> listaComprasEfetuadas;
    private String nome;
    private long cpf;
    private int idade;

    public Cliente() {
    	listaComprasEfetuadas = new ArrayList<>();
    }

    public Cliente(String nome, long cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        listaComprasEfetuadas = new ArrayList<>();
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

    public void fechaCompra(Carrinho carrinho) {
    	listaComprasEfetuadas.add(carrinho);
    }
    
    public String[] clienteJtableStruct() {
        return new String[]{nome, String.valueOf(cpf), String.valueOf(idade)};
    }
    
    public ArrayList<Produto> listagemProdutosComprados(){
    	ArrayList<Produto> aux = new ArrayList<>();
    	for (Carrinho c : listaComprasEfetuadas) {
    		aux.addAll(c.listaProdutosCarrinho);
    	}
    	return aux;
    }

}