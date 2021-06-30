package blocoinicializacao.dominio;

public class Anime {

	private String nome;
	private int[] episodios;
	// 1 - alocado espaço em memória
	// 2 - cada atributo de classe é criado e inicializado com valores default ou o que for passado
	// 3 - bloco de incialização é executado
	// 4 - construtor é executado
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
