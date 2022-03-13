package streams.test;

import streams.dominio.Category;
import streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest12 {

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
        Map<Category, List<LightNovel>> categoryLightNovelMap = new HashMap<>();

        List<LightNovel> fantasy = new ArrayList<>();
        List<LightNovel> drama = new ArrayList<>();
        List<LightNovel> romance = new ArrayList<>();

        for (LightNovel lightNovel : lightNovels) {
            switch (lightNovel.getCategory()) {
                case DRAMA:
                    drama.add(lightNovel);
                    break;
                case FANTASY:
                    fantasy.add(lightNovel);
                    break;
                case ROMANCE:
                    romance.add(lightNovel);
                    break;
            }
            categoryLightNovelMap.put(Category.DRAMA, drama);
            categoryLightNovelMap.put(Category.FANTASY, fantasy);
            categoryLightNovelMap.put(Category.ROMANCE, romance);
        }
        System.out.println(categoryLightNovelMap);

        //com essa única linha, ele faz a mesma lógica que está acima
        Map<Category, List<LightNovel>> groupBy = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory));
        System.out.println(groupBy);


    }
}
