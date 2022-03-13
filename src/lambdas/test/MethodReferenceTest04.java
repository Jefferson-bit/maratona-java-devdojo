package lambdas.test;

import lambdas.dominio.Anime;
import lambdas.servico.AnimeComparators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class MethodReferenceTest04 {

    public static void main(String[] args) {
        //não é nessa linha que o objeto é criado, ele é criado chamado o GET() do supplier, ele retorna o objeto
        Supplier<AnimeComparators> newAnimesComparators = AnimeComparators::new;
        AnimeComparators animeComparators = newAnimesComparators.get();


        List<Anime> animeList = new ArrayList(List.of(
                new Anime("Berserk", 5),
                new Anime("Demon Slayer", 25),
                new Anime("Mirai Nikky", 12)));

//        stringList.sort( (a1,a2) -> animeComparators.compareByEpisodesNoStatic(a1, a2));
        animeList.sort(animeComparators::compareByEpisodesNoStatic);

        System.out.println(animeList);

        BiFunction<String, Integer, Anime> animeBiFunction1 = (title, episodes) -> new Anime(title, episodes);
        BiFunction<String, Integer, Anime> animeBiFunction2 = Anime::new;
        System.out.println(animeBiFunction2.apply("Another", 12));


    }
}
