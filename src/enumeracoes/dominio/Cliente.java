package enumeracoes.dominio;


public class Cliente {
	
	private String nome;
	private TipoClient tipoCliente;
	public tipoPagamento tipoPagamento;

	public Cliente(String nome, TipoClient tipoCliente, tipoPagamento tipoPagamento) {
		super();
		this.nome = nome;
		this.tipoCliente = tipoCliente;
		this.tipoPagamento = tipoPagamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoClient getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoClient tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public tipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(tipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome 
				+ ", tipoCliente=" + tipoCliente
				+", tipoClienteInt=" + tipoCliente.getValor()
				+ ", tipoPagamento=" + tipoPagamento + "]";
	}

}
