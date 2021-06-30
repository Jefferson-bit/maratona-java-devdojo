package modificadorestatico.test;

import modificadorestatico.dominio.Carro;

public class CarroTest01 {

	public static void main(String[] args) {
		Carro.setVelocidadeLimite(130.0);

		Carro c1 = new Carro("BMW", 280.0);
		Carro c2 = new Carro("Mustang", 200.0);
		Carro c3 = new Carro("Impala", 160.0);
		
		c1.imprime();
		c2.imprime();
		c3.imprime();
	}

}
