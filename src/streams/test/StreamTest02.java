package streams.test;

import streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest02 {

    private static List<LightNovel> lightNovels = new ArrayList(List.of(
            new LightNovel("Demon Slayer", 1.99),
            new LightNovel("Bleach", 2.99),
            new LightNovel("Dororo", 4.0),
            new LightNovel("Another", 3.52),
            new LightNovel("Berserk", 6.99),
            new LightNovel("One Punch Man", 7.99),
            new LightNovel("Boku no Hero", 8.99)
    ));

    public static void main(String[] args) {
        //na stream temos operações. Operações em stream são intermediarias ou finais
        //Intermediaria: Retorna o próprio Stream, podendo encadear ações, filtra, ordenar, remover, tudo isso retorna um novo stream
        //
//        Stream<LightNovel> stream = lightNovels.stream();
        List<String> titles = lightNovels.stream()
                .sorted(Comparator.comparing(LightNovel::getTitle))
                .filter(lightNovel -> lightNovel.getPrice() <= 4)
                .limit(3)
                .map(LightNovel::getTitle)
                .collect(Collectors.toList());

        System.out.println(titles);
    }
}
