package polimorfismo.test;

import polimorfismo.dominio.Computador;
import polimorfismo.dominio.Tomate;
import polimorfismo.servico.CalculadoraImposto;

public class ProdutoTest01 {
	public static void main(String[] args) {
		Computador computador = new Computador("nuc10I7", 11000.0 );
		Tomate tomate = new Tomate("Tomate ciciliano", 10.0);
		
		CalculadoraImposto.calculaImposto(computador);
		System.out.println("-----------------------------");
		CalculadoraImposto.calculaImposto(tomate);
	}
}
