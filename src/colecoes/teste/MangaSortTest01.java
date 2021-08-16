package colecoes.teste;

import colecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SortMangaByIdComparator implements Comparator<Manga>{

    @Override
    public int compare(Manga manga1, Manga manga2) {
        return manga1.getId().compareTo(manga2.getId());
    }




public class MangaSortTest01 {

    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>();
        mangas.add(new Manga(5L, "Pokemon", 120.0));
        mangas.add(new Manga(1L,"Demon Slayer", 300.0));
        mangas.add(new Manga(14L,"Hokuto no Ken", 125.0));
        mangas.add(new Manga(7L,"Attack on Titan", 33.0));
        mangas.add(new Manga(23L,"Dragon ball z", 44.0));

        Collections.sort(mangas);
        for (Manga manga: mangas) {
            System.out.println(manga);
        }

        System.out.println("-------------------------");

        Collections.sort(mangas, new SortMangaByIdComparator());
        for (Manga manga: mangas) {
            System.out.println(manga);
        }

    }
}
