package controller;

import model.Cosmetico;
import model.Filial;
import model.Remedio;

public class ControleProduto {
    Filial filial = new Filial();

    public Integer quantidadeProdutos() {
        return filial.getListaProdutosCadastrados().size();
    }

    public void salvaCosmetico(String nome, Double preco, String descricao,
            String textura, String fragrancia, String corante) {
        Cosmetico cosmetico = new Cosmetico(nome, preco, descricao, textura, fragrancia, corante);
        filial.addProduto(cosmetico);
    }

    public void salvaRemedio(String nome, Double preco, String descricao,
            String dosagem, String formula, String administracao) {
        Remedio remedio = new Remedio(nome, preco, descricao, dosagem, formula, administracao);
        filial.addProduto(remedio);
    }

//    public String[] lerCosmetico() {
//
//    }

//    public String[] lerRemedio() {
//
//    }


    public void  removerProduto(Integer indexLinha) {
        filial.removeProduto(filial.getListaProdutosCadastrados().get(indexLinha));
    }

}