package colecoes.teste;

import colecoes.dominio.Manga;

import java.util.HashSet;
import java.util.Set;

public class SetTest01 {

    public static void main(String[] args) {

        Set<Manga> mangas = new HashSet<>();
        mangas.add(new Manga(5L, "Hellsing Ultimate", 19.0, 0));
        mangas.add(new Manga(1L, "Demon Slayer", 9.5, 5));
        mangas.add(new Manga(14L, "Hokuto no Ken", 3.5, 2));
        mangas.add(new Manga(7L, "Attack on Titan", 33.0, 1));
        mangas.add(new Manga(23L, "Dragon ball z", 44.0, 8));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }
    }
}
