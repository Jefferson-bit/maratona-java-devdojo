package colecoes.teste;

import colecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BinarySearchTest02 {
    public static void main(String[] args) {

        SortMangaByIdComparator sortMangaByIdComparator = new SortMangaByIdComparator();
        List<Manga> mangas = new ArrayList<>();
        mangas.add(new Manga(1L, "Pokemon", 120.0));
        mangas.add(new Manga(2L,"Demon Slayer", 300.0));
        mangas.add(new Manga(3L,"Hokuto no Ken", 125.0));
        mangas.add(new Manga(4L,"Attack on Titan", 33.0));
        mangas.add(new Manga(5L,"Dragon ball z", 44.0));

        mangas.sort(sortMangaByIdComparator);
        for (Manga manga: mangas) {
            System.out.println(manga);
        }
        Manga mangaToSearch = new Manga(5L, "Dragon ball z", 44.0);
        System.out.println(Collections.binarySearch(mangas, mangaToSearch, sortMangaByIdComparator));

        var lista = List.of("Alguma coisa");
        var mangaaa = lista.stream().map(obj -> new Integer(12)).collect(Collectors.toList());


    }
}
