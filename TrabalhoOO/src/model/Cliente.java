package model;

import java.util.ArrayList;

public class Cliente {
	ArrayList<Carrinho> listaComprasEfetuadas;
    private String nome;
    private String cpf;
    private String idade;

    public Cliente() {
    	listaComprasEfetuadas = new ArrayList<>();
    }

    public Cliente(String nome, String cpf, String idade) {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public void fechaCompra(Carrinho carrinho) {
    	listaComprasEfetuadas.add(carrinho);
    }
    
    public ArrayList<Produto> listagemProdutosComprados(){
    	ArrayList<Produto> aux = new ArrayList<>();
    	for (Carrinho c : listaComprasEfetuadas) {
    		aux.addAll(c.listaProdutosCarrinho);
    	}
    	return aux;
    }
    
}