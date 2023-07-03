package model;

import java.util.ArrayList;

/**
 * Classe Empresa que faz o gerenciamento de dados do programa. 
 * @author Caio
 * @since 2023
 */
public class Empresa {
	
	private String nome;
	private ArrayList<Cliente> listaClientesCadastrados = new ArrayList<Cliente>();
	private ArrayList<Filial> listaFiliaisCadastradas = new ArrayList<Filial>();
	
	/**
	 * Construtor da classe Empresa.
	 */
	public Empresa() {
		this.nome = "Farmácias FGA";
	}

	public String getNome() {
		return nome;
	}

	public ArrayList<Cliente> getListaClientesCadastrados() {
		return listaClientesCadastrados;
	}

	public void setListaClientesCadastrados(ArrayList<Cliente> listaClientesCadastrados) {
		this.listaClientesCadastrados = listaClientesCadastrados;
	}

	public ArrayList<Filial> getListaFiliaisCadastradas() {
		return listaFiliaisCadastradas;
	}

	public void setListaFiliaisCadastradas(ArrayList<Filial> listaFiliaisCadastradas) {
		this.listaFiliaisCadastradas = listaFiliaisCadastradas;
	}
	
	public void dadosAleatoriosFilial() {
        for (int i = 0; i < 3; i++)
        {
            Filial filial = new Filial("Brasília", "SMPW " + i + 1, 124123*(i + 1));
            listaFiliaisCadastradas.add(filial);
        }

        Filial f = new Filial("São paulo", "Avenida paulista", 12314512);
        listaFiliaisCadastradas.add(f);
    }
	
	public void dadosAleatoriosCliente() {
        for (int i = 0; i < 3; i++)
        {
            Cliente cliente = new Cliente("Cliente " + (i+1) ,134*(i+1), 10*(i+1));
            listaClientesCadastrados.add(cliente);
        }

    }

}
