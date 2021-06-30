package polimorfismo.servico;

import polimorfismo.repositorio.Repositorio;

public class RepositorioBancoDeDados implements Repositorio{

	@Override
	public void salvar() {
		System.out.println("Salvando Banco de dados");
		
	}
}
