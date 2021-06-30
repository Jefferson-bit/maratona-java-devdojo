package polimorfismo.test;

import polimorfismo.dominio.Computador;
import polimorfismo.dominio.Produto;
import polimorfismo.dominio.Tomate;
import polimorfismo.servico.CalculadoraImposto;

public class ProdutoTest03 {
	public static void main(String[] args) {
		Produto produto = new Computador("nuc10I7", 11000.0 );
		Tomate tomate = new Tomate("Tomate ciciliano", 10.0);
		tomate.setDataDeValidade("03/10/2021");
		
		CalculadoraImposto.calculaImposto(tomate);
		System.out.println("----------------------");
		CalculadoraImposto.calculaImposto(produto);
	}
}
