package streams.test;

import streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest06 {

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
        // existe algum elemento na lista maior que nove?
        System.out.println(lightNovels.stream().anyMatch(lightNovel -> lightNovel.getPrice() > 9));
        //todos elementos são maiores que zero?
        System.out.println(lightNovels.stream().allMatch(lightNovel -> lightNovel.getPrice() > 0));
        //nenhum elementos e menor que zero?
        System.out.println(lightNovels.stream().noneMatch(lightNovel -> lightNovel.getPrice() < 0));
        lightNovels.stream()
                .filter(lightNovel -> lightNovel.getPrice() > 3)
                //so se utiliza findAny quando n se importa com o resultado
                .findAny()
                .ifPresent(System.out::println);

        lightNovels.stream()
                .filter( lightNovel ->  lightNovel.getPrice() > 3)
                .sorted(Comparator.comparing(LightNovel::getPrice).reversed())
                //encontra o primeiro elemento da lista que for maior que 3
                .findFirst()
                .ifPresent(System.out::println);
    }
}
