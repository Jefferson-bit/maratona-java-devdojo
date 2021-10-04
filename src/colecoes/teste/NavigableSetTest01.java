package colecoes.teste;

import colecoes.dominio.Manga;
import colecoes.dominio.SmartPhone;

import java.util.*;


class SmartphoneCompartor implements Comparator<SmartPhone> {

    @Override
    public int compare(SmartPhone o1, SmartPhone o2) {
        return o1.getMarca().compareTo(o2.getMarca());
    }
}

class MangaComparator implements Comparator<Manga>{

    @Override
    public int compare(Manga o1, Manga o2) {
        return Double.compare(o1.getPreco(), o2.getPreco());
    }
}


public class NavigableSetTest01 {
    public static void main(String[] args) {
        //geralmente classes com a palavra tree, basicamente eles trabalham linkado com a parte de vc ter o comparato
        NavigableSet<SmartPhone> set = new TreeSet(new SmartphoneCompartor());
        SmartPhone nokia = new SmartPhone("123", "nokia");
        set.add(nokia);


        // ele ordena baseado no compareto  ou o compare que a gente passa no treeSet
        // ele não utiliza o equals para verificar se dois elementos são iguais, se baseia no compareTo ou Comparable
        NavigableSet<Manga> mangas = new TreeSet<>(new MangaComparator());
        mangas.add(new Manga(5L, "Pokemon", 120.0, 2));
        mangas.add(new Manga(1L, "Demon Slayer", 39.6, 3));
        mangas.add(new Manga(14L, "Hokuto no Ken", 55.9, 4));
        mangas.add(new Manga(7L, "Attack on Titan", 33.0, 6));
        mangas.add(new Manga(23L, "Dragon ball z", 44.0, 1));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }
        //vai de baixo pra cima
        for (Manga manga : mangas.descendingSet()) {
            System.out.println(manga);
        }

        //lowe: < traz o que é imediatamente o menor
        //floor: <= retorna o mesmo elemento caso exista ou de imediato o que está abaixo dele
        //higher: > traz o que é imediatamente o maior
        //ceiling >= retorna o mesmo elemento caso exista ou de imediato o que está acima dele

        Manga yuyu = new Manga(14L, "Hokuto no Ken", 90.0, 1);

        System.out.println("===================================");
        System.out.println(mangas.lower(yuyu));
        System.out.println(mangas.floor(yuyu));
        System.out.println(mangas.higher(yuyu));
        System.out.println(mangas.ceiling(yuyu));
        System.out.println("=======================");
        System.out.println(mangas.size());
        System.out.println(mangas.pollFirst());
        System.out.println(mangas.size());
        System.out.println(mangas.pollLast());
        System.out.println(mangas.size());



    }
}
