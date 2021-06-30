package enumeracoes.dominio;

public enum TipoClient {
	PESSOA_FISICA(1, "Pessoa Fisica"),
	PESSOA_JURIDICA(2, "Pessoa Juridica");

	private int valor;
	private String nomeRelatorio;
	
	TipoClient(int valor,String nomeRelatorio) {
		this.valor = valor;
		this.nomeRelatorio = nomeRelatorio;
	}

	public static TipoClient tipoClientePorNomeRelatorio(String nomeRelatorio) {
		for (TipoClient tipoClient: values()) {
			if(tipoClient.getNomeRelatorio().equals(nomeRelatorio)) {
				return tipoClient;
			}
		}
		return null;
	}
	
	public int getValor() {
		return valor;
	}

	public String getNomeRelatorio() {
		return nomeRelatorio;
	}
	
}
