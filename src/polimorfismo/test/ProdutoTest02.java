package polimorfismo.test;

import polimorfismo.dominio.Computador;
import polimorfismo.dominio.Produto;
import polimorfismo.dominio.Tomate;

public class ProdutoTest02 {
	public static void main(String[] args) {
		Produto produto = new Computador("Ryzen 9", 3000.0);
		System.out.println(produto.getNome());
		System.out.println(produto.getValor());
		System.out.println(produto.calcularImposto());
		System.out.println("------------------");
	
		Produto produto1 = new Tomate("Americano", 20.0);
		System.out.println(produto1.getNome());
		System.out.println(produto1.getValor());
		System.out.println(produto1.calcularImposto());
	}
}
