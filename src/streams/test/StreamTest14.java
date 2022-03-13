package streams.test;

import streams.dominio.Category;
import streams.dominio.LightNovel;
import streams.dominio.Promotion;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static streams.dominio.Promotion.NORMAL_PRICE;
import static streams.dominio.Promotion.UNDER_PROMOTION;

public class StreamTest14 {

    private static List<LightNovel> lightNovels = new ArrayList(List.of(

            new LightNovel("Demon Slayer", 3.23, Category.FANTASY),
            new LightNovel("Bleach", 3.99, Category.FANTASY),
            new LightNovel("Dororo", 4.0, Category.DRAMA),
            new LightNovel("Another", 3.52, Category.DRAMA),
            new LightNovel("Berserk", 6.99, Category.FANTASY),
            new LightNovel("One Punch Man", 7.99, Category.FANTASY),
            new LightNovel("Boku no Hero", 8.99, Category.ROMANCE)
    ));

    public static void main(String[] args) {
        Map<Category, Long> collect = lightNovels.stream().collect(groupingBy(LightNovel::getCategory, Collectors.counting()));
        System.out.println(collect);

        Map<Category, Optional<LightNovel>> collect1 =
                lightNovels.stream()
                        .collect(groupingBy(LightNovel::getCategory,
                                Collectors.maxBy(Comparator.comparing(LightNovel::getPrice))));

        Map<Category, LightNovel> collect2 = lightNovels.stream()
                .collect(groupingBy(LightNovel::getCategory,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(LightNovel::getPrice)), Optional::get)));
        System.out.println(collect2);

        Map<Category, LightNovel> collect3 = lightNovels.stream()
                .collect(Collectors.toMap(LightNovel::getCategory, Function.identity(), BinaryOperator.maxBy(Comparator.comparing(LightNovel::getPrice))));
        System.out.println(collect3);
    }
}
