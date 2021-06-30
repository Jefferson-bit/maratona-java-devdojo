package heranca.test;

import heranca.dominio.Funcionario;

public class HerancaTest02 {
	// 0 - bloco de inicialização estatico da superclasse é executado quando a jVM carregar a classe pai 
	// 1 - bloco de inicialização estatico da subrclasse é executado quando a jVM carregar a classe filha
	// 2 - alocado espaço em memória da superclasse pai
	// 3 - cada atributo da superclasse é criado e inicializado com valores default ou o que for passado
	// 4 - bloco de incialização da superclasse é executado na ordem em que aparece
	// 5 - construtor é executado da superclasse é executado 
	// 6 - alocado espaço em memória da subclasse pai
	// 7 - cada atributo da subclasse é criado e inicializado com valores default ou o que for passado
	// 8 - bloco de incialização da subclasse é executado na ordem em que aparece
	// 9 - construtor é executado da subclasse é executado 
	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario("Devdojo");
		funcionario.setCpf(null);
	}
}
