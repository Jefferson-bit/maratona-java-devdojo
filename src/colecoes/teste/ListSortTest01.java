package colecoes.teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortTest01 {

    public static void main(String[] args) {
        List<String> mangas = new ArrayList<>();
        mangas.add("Pokemon");
        mangas.add("Demon Slayer");
        mangas.add("Hokuto no Ken");
        mangas.add("Attack on Titan");
        mangas.add("Dragon ball z");

        Collections.sort(mangas);

        for (String manga: mangas){
            System.out.println(manga);
        }
    }

}
