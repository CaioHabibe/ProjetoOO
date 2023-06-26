package controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Cliente;
import model.Filial;

public class ControleFilial {

	private ArrayList <Filial> listaDeFiliais = new ArrayList<Filial>();

	public void salvarFilial(String cidade, String endereco, String cnpj) {
			Filial filial = new Filial(cidade, endereco, cnpj);
			listaDeFiliais.add(filial);
	}
	
	public String ler() {
		return listaDeFiliais.toString();
	}
	
	public void  remover (String cidade) {
		for (Filial filial : listaDeFiliais) {
			if (filial.getCidade() == cidade) {
				listaDeFiliais.remove(filial);
				break;
			}
		}
	}
	
	public void alterar (Filial filial) {
		for (Filial aux : listaDeFiliais) {
			if (aux.getCidade() == filial.getCidade()) {
				listaDeFiliais.remove(aux);
				listaDeFiliais.add(filial);
				break;
			}
		}
	}
	
//	public ArrayList<Cliente> listaDeClientes() {
//		ArrayList<Cliente> lista = new ArrayList<>();
//		Cliente c0 = new Cliente("Lucas", "08287845150", 19);
//		Cliente c1 = new Cliente("Artur", "08287845151", 19);
//		Cliente c2 = new Cliente("Caio", "08287845152", 19);
//		Cliente c3 = new Cliente("João", "08287845153", 19);
//		Cliente c4 = new Cliente("Otávio", "08287845154", 19);
//		lista.add(c0); lista.add(c1); lista.add(c2); lista.add(c3); lista.add(c4);
//		return lista;
//	}
//	
//	public void adicionaLinha() {
//		DefaultTableModel model = (DefaultTableModel) table.getModel();
//		ArrayList<Cliente> lista = listaDeClientes();
//		Object contLinha[] = new Object[10];
//		for (int i = 0; i < lista.size(); i++) {
//			contLinha[0] = lista.get(i).getNome();
//			contLinha[1] = lista.get(i).getCpf();
//			contLinha[2] = lista.get(i).getIdade();
//			model.addRow(contLinha);
//		}
//		
//	}
	
}
