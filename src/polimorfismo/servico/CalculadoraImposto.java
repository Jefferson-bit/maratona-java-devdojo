package polimorfismo.servico;

import polimorfismo.dominio.Produto;
import polimorfismo.dominio.Tomate;

public class CalculadoraImposto {

	public static void calculaImposto(Produto produto) {
		System.out.println("Relatorio de imposto: ");
		double imposto = +produto.calcularImposto();
		System.out.println("Produto: " + produto.getNome());
		System.out.println("Preço " + produto.getValor());
		System.out.println("Imposto a ser pago " + imposto);
		if (produto instanceof Tomate) {
			Tomate tomate = (Tomate) produto;
			System.out.println(tomate.getDataDeValidade());

		}
	}
}
