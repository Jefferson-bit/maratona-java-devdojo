package lambdas.test;

import lambdas.dominio.Anime;
import lambdas.servico.AnimeComparators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

//Reference to an instance method of an arbitrary object of a particular type
public class MethodReferencesTest03 {

    public static void main(String[] args) {
        AnimeComparators animeComparators = new AnimeComparators();

        List<String> stringList = new ArrayList(List.of("Eren", "Armin", "Jean"));
        stringList.sort(String::compareTo);

        System.out.println(stringList);

        Function<String, Integer> numStringToInteger = s -> Integer.parseInt(s);
        Function<String, Integer> numStringToInteger2 =  Integer::parseInt;

        System.out.println(numStringToInteger.apply("12222"));
        System.out.println(numStringToInteger2.apply("10"));


        BiPredicate<List<String>, String> checkName = List::contains;
        System.out.println(checkName.test(stringList, "Eren"));
    }
}
