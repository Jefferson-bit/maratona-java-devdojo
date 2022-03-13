package streams.test;

import streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest11 {
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
        System.out.println(lightNovels.stream().collect(Collectors.counting()));

        lightNovels.stream()
                .max(Comparator.comparing(LightNovel::getPrice)).ifPresent(System.out::println);

        lightNovels.stream().collect(Collectors.maxBy(Comparator.comparing(LightNovel::getPrice)))
                .ifPresent(System.out::println);

        System.out.println(lightNovels.stream().mapToDouble(LightNovel::getPrice).sum());
        System.out.println(lightNovels.stream().collect(Collectors.summingDouble(LightNovel::getPrice)));

        //isso aqui já da a media, minima, maxima e a soma total
        DoubleSummaryStatistics collect = lightNovels.stream().collect(Collectors.summarizingDouble(LightNovel::getPrice));
        System.out.println(collect);

        String titles = lightNovels.stream().map(LightNovel::getTitle).collect(Collectors.joining(", "));

        System.out.println(titles);

    }
}
