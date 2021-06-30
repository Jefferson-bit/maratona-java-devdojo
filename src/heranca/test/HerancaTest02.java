package heranca.test;

import heranca.dominio.Funcionario;

public class HerancaTest02 {
	// 0 - bloco de inicializa��o estatico da superclasse � executado quando a jVM carregar a classe pai 
	// 1 - bloco de inicializa��o estatico da subrclasse � executado quando a jVM carregar a classe filha
	// 2 - alocado espa�o em mem�ria da superclasse pai
	// 3 - cada atributo da superclasse � criado e inicializado com valores default ou o que for passado
	// 4 - bloco de incializa��o da superclasse � executado na ordem em que aparece
	// 5 - construtor � executado da superclasse � executado 
	// 6 - alocado espa�o em mem�ria da subclasse pai
	// 7 - cada atributo da subclasse � criado e inicializado com valores default ou o que for passado
	// 8 - bloco de incializa��o da subclasse � executado na ordem em que aparece
	// 9 - construtor � executado da subclasse � executado 
	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario("Devdojo");
		funcionario.setCpf(null);
	}
}
