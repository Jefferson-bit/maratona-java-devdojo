package associacao.test;

import associacao.dominio.Escola;
import associacao.dominio.Professor;

public class Escolatest01 {

	public static void main(String[] args) {
		
		Professor professor1 = new Professor("Jiraya Sensei");
		Professor professor2 = new Professor("Kakashi Sensei");
		Professor[] professores = {professor1, professor2};
		Escola escola = new Escola("Konoha", professores);
		escola.imprime();
		
		
	}

}
