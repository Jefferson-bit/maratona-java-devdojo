package classesabstratas.test;

import classesabstratas.dominio.Desenvolvedor;
import classesabstratas.dominio.Gerente;

public class FuncionarioTest01 {
	
	public static void main(String[] args) {
		Gerente gerente = new Gerente("Nami", 5000.0);
		System.out.println(gerente);
		Desenvolvedor desenvolvedor = new Desenvolvedor("Tooya", 2500.0);
		System.out.println(desenvolvedor);
	}
}
