package heranca.test;

import heranca.dominio.Endereco;
import heranca.dominio.Funcionario;
import heranca.dominio.Pessoa;

public class HerancaTest01 {

	public static void main(String[] args) {
		Endereco endereco = new Endereco();
		endereco.setRua("Rua 3");
		endereco.setCep("0123456789");

		Pessoa pessoa = new Pessoa("Inosuke");
		pessoa.setNome("Miazaky");
		pessoa.setCpf("1111111111");
		pessoa.setEndereco(endereco);
		
		pessoa.imprime();
		System.out.println("---------------");
		Funcionario funcionario = new Funcionario("Murata");
		funcionario.setNome("Tanjiro");
		funcionario.setCpf("222222");
		funcionario.setEndereco(endereco);
		funcionario.setSalario(200.0);
		funcionario.imprime();
	}
}
