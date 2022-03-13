package streams.test;

import streams.dominio.Category;
import streams.dominio.LightNovel;
import streams.dominio.Promotion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static streams.dominio.Promotion.*;

public class StreamTest13 {

    private static List<LightNovel> lightNovels = new ArrayList(List.of(

            new LightNovel("Demon Slayer", 3.23, Category.FANTASY),
            new LightNovel("Bleach", 3.99, Category.FANTASY),
            new LightNovel("Dororo", 4.0, Category.DRAMA),
            new LightNovel("Another", 3.52, Category.DRAMA),
            new LightNovel("Berserk", 6.99, Category.FANTASY),
            new LightNovel("One Punch Man", 7.99, Category.FANTASY),
            new LightNovel("Boku no Hero", 8.99, Category.FANTASY)
    ));

    public static void main(String[] args) {

        Map<Promotion, List<LightNovel>> collect =
                lightNovels
                        .stream()
                        .collect(groupingBy(lightNovel -> lightNovel.getPrice() < 6 ? UNDER_PROMOTION : NORMAL_PRICE));

        System.out.println(collect);
        //Map<Category,Map<Promotion, List<LightNovel>>>
        Map<Category, Map<Promotion, List<LightNovel>>> collect1 = lightNovels.stream().collect(groupingBy(LightNovel::getCategory,
                groupingBy(lightNovel -> getPromotion(lightNovel)))
        );

        System.out.println(collect1);
    }

    private static Promotion getPromotion(LightNovel lightNovel) {
        return lightNovel.getPrice() < 6 ? UNDER_PROMOTION : NORMAL_PRICE;
    }
}
