package streams.test;

import streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamTest07 {

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
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);

        integers.stream().reduce( (x, y)  -> x + y).ifPresent(System.out::println);

        System.out.println(integers.stream().reduce( 0, (x, y)  -> x + y));

        integers.stream().reduce(Integer::sum).ifPresent(System.out::println);
        System.out.println(integers.stream().reduce(0 ,Integer::sum));


        System.out.println("----------------");

        integers.stream().reduce( (x, y)  -> x * y).ifPresent(System.out::println);
        System.out.println(integers.stream().reduce( 1, (x, y)  -> x * y));


        System.out.println("----------------");

        integers.stream().reduce( (x, y)  -> x > y ? x : y).ifPresent(System.out::println);
        System.out.println(integers.stream().reduce( 0, Integer::max));

    }
}
