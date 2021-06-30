package sobrecarga.test;

import sobrecarga.dominio.Anime;

public class AnimeTest01 {
	public static void main(String[] args) {
		Anime anime = new Anime();
		anime.init("TV", 12, "Akudama Drive", "Ação");
		anime.imprime();

	}
}