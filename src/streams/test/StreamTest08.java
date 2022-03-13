package streams.test;

import streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.List;

public class StreamTest08 {

    private static List<LightNovel> lightNovels = new ArrayList(List.of(

            new LightNovel("Demon Slayer", 3.23),
            new LightNovel("Bleach", 3.99),
            new LightNovel("Dororo", 4.0),
            new LightNovel("Another", 3.52),
            new LightNovel("Berserk", 6.99),
            new LightNovel("One Punch Man", 7.99),
            new LightNovel("Boku no Hero", 8.99)
    ));


    public static void main(String[] args) {
        // não é recomendado fazer map para tipo primitivos, eles afetam a perfomance
        // caso você queira um map de double, existe um cara chamado mapToDouble que usa DoubleStream, assim
        // ele não fica fazaendo boxing e unboxing dos tipos
            lightNovels.stream()
                    .map(LightNovel::getPrice)
                    .filter(price -> price > 3)
                    .reduce(Double::sum)
                    .ifPresent(System.out::println);

        double sum = lightNovels.stream()
                .mapToDouble(LightNovel::getPrice)
                .filter(price -> price > 3)
                .sum();

        System.out.println(sum);

    }
}
