package streams.test;

import streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest03 {

    private static List<LightNovel> lightNovels = new ArrayList(List.of(
            new LightNovel("Demon Slayer", 1.99),
            new LightNovel("Demon Slayer", 1.99),
            new LightNovel("Bleach", 2.99),
            new LightNovel("Dororo", 4.0),
            new LightNovel("Another", 3.52),
            new LightNovel("Berserk", 6.99),
            new LightNovel("One Punch Man", 7.99),
            new LightNovel("Boku no Hero", 8.99)
    ));

    public static void main(String[] args) {
        //Operação terminal
        //stream aberta uma vez, ao serem usadas novamente, dará uma exceção, elas não podem mais ser utilzadas
        //O fluxo dos elementos da stream já foram fechado
        Stream<LightNovel> stream = lightNovels.stream();

        lightNovels.forEach(System.out::println);

        long count = stream.filter(ln -> ln.getPrice() <= 4)
                .count();
        //essa é uma maneira de reutilizar o stream
        long count1 = lightNovels.stream()
                //distinct precisa de equals and hashcode
                .distinct()
                .filter(ln -> ln.getPrice() <= 4)
                .count();

        System.out.println(count);
        System.out.println(count1);


    }
}
