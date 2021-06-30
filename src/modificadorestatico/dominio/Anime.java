package modificadorestatico.dominio;

public class Anime {

	private String nome;
	private static int[] episodios;
	// 0 - bloco de inicializa��o estatico � executado quando a jVM carregar a classe
	// 1 - alocado espa�o em mem�ria
	// 2 - cada atributo de classe � criado e inicializado com valores default ou o que for passado
	// 3 - bloco de incializa��o � executado
	// 4 - construtor � executado
	static {
		//bloco de inicializa��o
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
