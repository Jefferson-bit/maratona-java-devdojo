package blocoinicializacao.dominio;

public class Anime {

	private String nome;
	private int[] episodios;
	// 1 - alocado espa�o em mem�ria
	// 2 - cada atributo de classe � criado e inicializado com valores default ou o que for passado
	// 3 - bloco de incializa��o � executado
	// 4 - construtor � executado
	{
		System.out.println("Dentro do bloco de inicializacao");
		episodios = new int[100];
		for (int i = 0; i < episodios.length; i++) {
			episodios[i] = i + 1;
		}
	}

	public Anime(String nome) {
		this.nome = nome;
	}

	public Anime() {
		for (int episodio : episodios) {
			System.out.print(episodio + " ");

		}
		System.out.println();
	}

	public String getNome() {
		return nome;
	}

	public int[] getEpisodios() {
		return episodios;
	}
}
