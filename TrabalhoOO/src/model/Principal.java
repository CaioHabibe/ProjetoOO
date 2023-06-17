package model;

public class TesteDasClasses {

	public static void main(String[] args) {
		Beleza shampoo = new Beleza("Shampoo", "Loreal", 30.00, 500,
				true, "Macio", "Pele seca");
		Beleza beleza1 = new Beleza("Sabão em pedra", "Loreal", 30.00, 500,
				true, "Macio", "Pele seca");
		Beleza beleza2 = new Beleza("Sabão líquido", "Loreal", 30.00, 500,
				true, "Macio", "Pele seca");
		Beleza beleza3 = new Beleza("Creme corporal", "Loreal", 30.00, 500,
				true, "Macio", "Pele seca");
		Beleza beleza4 = new Beleza("Fragrância", "Loreal", 30.00, 500,
				true, "Macio", "Pele seca");
		//System.out.println(beleza.toString());
		//beleza.setNome("Sabão");
		//System.out.println(beleza.toString());
		
		Remedio remedio = new Remedio("Dipirona", "Neo quimica",
				30.00, 1500, 30.00, "Cloridato de Para-benzenol"
				, "Oral");
		Remedio remedio1 = new Remedio("Advil", "Neo quimica",
				30.00, 1500, 30.00, "Cloridato de Para-benzenol"
				, "Oral");
		Remedio remedio2 = new Remedio("Paracetamol", "Neo quimica",
				30.00, 1500, 30.00, "Cloridato de Para-benzenol"
				, "Oral");
		Remedio remedio3 = new Remedio("Alprazolam", "Neo quimica",
				30.00, 1500, 30.00, "Cloridato de Para-benzenol"
				, "Oral");
		Remedio remedio4 = new Remedio("Rivotril", "Neo quimica",
				30.00, 1500, 30.00, "Cloridato de Para-benzenol"
				, "Oral");
		//System.out.println(remedio);
		//remedio.setNome("Paracetamol");
		//System.out.println(remedio);
		
		Carrinho carrinho = new Carrinho(1);
		carrinho.addCarrinho(shampoo);
		carrinho.addCarrinho(beleza1);
		carrinho.addCarrinho(beleza2);
		carrinho.addCarrinho(beleza3);
		carrinho.addCarrinho(beleza4);
		carrinho.addCarrinho(remedio);
		carrinho.addCarrinho(remedio1);
		carrinho.addCarrinho(remedio2);
		carrinho.addCarrinho(remedio3);
		carrinho.addCarrinho(remedio4);
		
		//System.out.println(carrinho.getCarrinhoProdutos().size());
		//System.out.println(carrinho.fechaCarrinho(carrinho.getCarrinhoProdutos()));
		
		//carrinho.excluiCarrinho(beleza);
		//carrinho.excluiCarrinho(beleza3);
		
		//System.out.println(carrinho.getCarrinhoProdutos().size());
		//System.out.println(carrinho.fechaCarrinho(carrinho.getCarrinhoProdutos()));
		
		//carrinho.addCarrinho(beleza);
		//System.out.println(carrinho.getCarrinhoProdutos().size());
		//System.out.println(carrinho.fechaCarrinho(carrinho.getCarrinhoProdutos()));
		
		Filial filial = new Filial("Brasilia", "SMPW QD 1", 71735500);
		Filial filial1 = new Filial("Brasilia", "SMPW QD 2", 71735501);
		Filial filial2 = new Filial("Brasilia", "SMPW QD 3", 71735502);
		Filial filial3 = new Filial("Brasilia", "SMPW QD 4", 71735503);
		Filial filial4 = new Filial("Brasilia", "SMPW QD 5", 71735504);
		Filial filial5 = new Filial("Brasilia", "SMPW QD 6", 71735505);
		
		filial.addProduto(shampoo);
		filial.addProduto(beleza1);
		filial.addProduto(beleza2);
		filial.addProduto(beleza3);
		filial.addProduto(beleza4);
		
		//System.out.println(filial.listaProdutosCadastrados(filial.getProdutosCadastrados()));
		//System.out.println(filial.buscaProdutoNome(shampoo));
		
		Empresa empresa = new Empresa("Drogaria São Paulo");
		
		//System.out.println(empresa.getNome());
		
		empresa.addFilial(filial);
		empresa.addFilial(filial1);
		empresa.addFilial(filial2);
		empresa.addFilial(filial3);
		empresa.addFilial(filial4);
		empresa.addFilial(filial5);
		//System.out.println(empresa.getFiliaisCadastradas().size());
		
		//System.out.println(empresa);
		//empresa.addFilial(filial);
		//System.out.println(empresa.getFiliaisCadastradas());
		
		carrinho.fechaCarrinho(carrinho.getCarrinhoProdutos());
		
		Cliente cliente = new Cliente("Lucas", "991498776", "08287845157", 19, "laraujooo11@gmail.com");
		
		System.out.println(cliente.listaDeProdutosComprados(carrinho));
		
		
		
	}

}
