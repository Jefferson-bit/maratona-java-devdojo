package polimorfismo.test;

import polimorfismo.repositorio.Repositorio;
import polimorfismo.servico.RepositorioArquivo;

public class RepositorioTest01 {

	public static void main(String[] args) {
		Repositorio repositorio = new RepositorioArquivo();
		repositorio.salvar();
		
	}
}
