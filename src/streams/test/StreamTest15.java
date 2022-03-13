package streams.test;

import streams.dominio.Category;
import streams.dominio.LightNovel;
import streams.dominio.Promotion;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static streams.dominio.Promotion.NORMAL_PRICE;
import static streams.dominio.Promotion.UNDER_PROMOTION;

public class StreamTest15 {

    private static List<LightNovel> lightNovels = new ArrayList(List.of(

            new LightNovel("Berserk", 6.99, Category.FANTASY),
            new LightNovel("Dororo", 4.0, Category.DRAMA),
            new LightNovel("Demon Slayer", 3.23, Category.FANTASY),
            new LightNovel("Bleach", 3.99, Category.FANTASY),
            new LightNovel("Another", 3.52, Category.DRAMA),
            new LightNovel("One Punch Man", 7.99, Category.FANTASY),
            new LightNovel("Boku no Hero", 8.99, Category.ROMANCE)
    ));

    public static void main(String[] args) {

        Map<Category, DoubleSummaryStatistics> collect = lightNovels.stream().collect(groupingBy(LightNovel::getCategory, summarizingDouble(LightNovel::getPrice)));
        System.out.println(collect);

        System.out.println("----------------------------");
        Map<Category, Set<Promotion>> collect1 = lightNovels.stream()
                .collect(groupingBy(LightNovel::getCategory,
                        mapping(StreamTest15::getPromotion, toSet())));

        System.out.println(collect1);

        Map<Category, Collection<Promotion>> collect2 = lightNovels.stream()
                .collect(groupingBy(LightNovel::getCategory,
                        mapping(StreamTest15::getPromotion, toCollection(LinkedHashSet::new))));
        System.out.println("----------------------------");

        System.out.println(collect2);
    }

    private static Promotion getPromotion(LightNovel lightNovel) {
        return lightNovel.getPrice() < 6 ? UNDER_PROMOTION : NORMAL_PRICE;
    }
}
