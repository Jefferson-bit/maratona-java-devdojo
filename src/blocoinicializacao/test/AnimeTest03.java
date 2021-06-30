package blocoinicializacao.test;

import blocoinicializacao.dominio.Anime;

public class AnimeTest03 {

	public static void main(String[] args) {
		Anime anime = new Anime();

		for (int epi : anime.getEpisodios()) {
			System.out.print(epi + " ");
		}

	}
}
