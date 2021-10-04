package colecoes.teste;

import colecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>();
        mangas.add(new Manga(5L, "Hellsing Ultimate", 19.0, 0));
        mangas.add(new Manga(1L, "Demon Slayer", 9.5, 5));
        mangas.add(new Manga(14L, "Hokuto no Ken", 3.5, 2));
        mangas.add(new Manga(7L, "Attack on Titan", 33.0, 1));
        mangas.add(new Manga(23L, "Dragon ball z", 44.0, 8));


        // iterator serve pra checkar antes de fazer uma ação
//        Iterator<Manga> mangaIterator = mangas.iterator();
//        while(mangaIterator.hasNext() ){
//            Manga manga = mangaIterator.next();
//            if(manga.getQuantidade() == 0){
//                mangaIterator.remove();
//            }
//        }
        mangas.removeIf( obj -> obj.getQuantidade() == 0);
    }
}
