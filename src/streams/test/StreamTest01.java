package streams.test;

import streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// streamns são sequencias de elementos, diferente de coleções que são elementos dentro de um espaço
// guardando dados e coleções em memoria. Stream são elementos que estão no tempo, porque trabalhamos com a sequencia
// e não estamo guardando nada
public class StreamTest01 {

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
        lightNovels.sort(Comparator.comparing(LightNovel::getTitle));
        List<String> titles = new ArrayList<>();
        for (LightNovel lightNovel : lightNovels) {
            if (lightNovel.getPrice() <= 4) {
                titles.add(lightNovel.getTitle());
            }
            if (titles.size() >= 3) {
                break;
            }
        }

        System.out.println(lightNovels);
    }
}
