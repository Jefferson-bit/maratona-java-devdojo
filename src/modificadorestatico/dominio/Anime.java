package modificadorestatico.dominio;

public class Anime {

	private String nome;
	private static int[] episodios;
	// 0 - bloco de inicialização estatico é executado quando a jVM carregar a classe
	// 1 - alocado espaço em memória
	// 2 - cada atributo de classe é criado e inicializado com valores default ou o que for passado
	// 3 - bloco de incialização é executado
	// 4 - construtor é executado
	static {
		//bloco de inicialização
		System.out.println("Dentro do bloco de inicializacao 1");
		episodios = new int[100];
		for (int i = 0; i < episodios.length; i++) {
			episodios[i] = i + 1;
		}
	}

	static {
		System.out.println("Dentro do bloco de inicializacao 2");
	}
	
	static {
		System.out.println("Dentro do bloco de inicializacao 3");
	}
	
	
	public Anime(String nome) {
		this.nome = nome;
	}

	public Anime() {
		for (int episodio : Anime.episodios) {
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
