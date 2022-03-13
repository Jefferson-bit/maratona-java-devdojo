package lambdas.test;

import lambdas.dominio.Anime;
import lambdas.servico.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

//method references to a static method
public class MethodReferencesTest02 {

    public static void main(String[] args) {
        AnimeComparators animeComparators = new AnimeComparators();

        List<Anime> animeList = new ArrayList(List.of(
                new Anime("Berserk", 5),
                new Anime("Demon Slayer", 25),
                new Anime("Mirai Nikky", 12)));
        animeList.sort(animeComparators::compareByEpisodesNoStatic);
        animeList.sort((a1, a2) -> animeComparators.compareByEpisodesNoStatic(a1, a2));
        System.out.println(animeList);
    }
}
