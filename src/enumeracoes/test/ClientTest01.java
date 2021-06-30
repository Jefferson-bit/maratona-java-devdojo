package enumeracoes.test;

import enumeracoes.dominio.Cliente;
import enumeracoes.dominio.TipoClient;
import enumeracoes.dominio.tipoPagamento;

public class ClientTest01 {
	public static void main(String[] args) {
		
		Cliente cli1 = new Cliente("Madara", TipoClient.PESSOA_FISICA, tipoPagamento.CREDITO);
		Cliente cli2 = new Cliente("Hashirama", TipoClient.PESSOA_JURIDICA, tipoPagamento.DEBITO);
		
		System.out.println(cli1);
		System.out.println(cli2);
		System.out.println(tipoPagamento.DEBITO.calculaDesconto(100));
		System.out.println(tipoPagamento.CREDITO.calculaDesconto(100));
		
		TipoClient tipoCliente = TipoClient.tipoClientePorNomeRelatorio("Pessoa Fisica");
		System.out.println(tipoCliente);
		
	}
	
}
