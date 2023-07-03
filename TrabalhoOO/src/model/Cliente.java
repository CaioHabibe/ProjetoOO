package model;

import java.util.ArrayList;

/**
 * Classe Cliente que serve de modelo para Cliente
 * @author Caio
 *
 */
public class Cliente {
	
	private ArrayList<String> listaComprasEfetuadas = new ArrayList<String>();
    private String nome;
    private long cpf;
    private int idade;
    private long senha;
    
    /**
     * Construtor da classe
     */
    public Cliente() {
    }
    
    public Cliente(String nome, long cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public long getSenha() {
		return senha;
	}

	public void setSenha(long senha) {
		this.senha = senha;
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
	
	/**
	 * Metodo que retorna dados de um Cliente em forma de array
	 * @return String
	 */
	public String[] clienteJtableStruct() {
        return new String[]{nome, String.valueOf(cpf), String.valueOf(idade)};
	}
	
	/**
	 * Metodo que retorna as compras de um cliente em um array.
	 * @return Object[]
	 */
	public Object[] compraJtableStruct() {
        return listaComprasEfetuadas.toArray();
	}

}