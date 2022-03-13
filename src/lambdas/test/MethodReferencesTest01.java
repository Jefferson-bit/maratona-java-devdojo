package lambdas.test;

import lambdas.dominio.Anime;
import lambdas.servico.AnimeComparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MethodReferencesTest01 {


    public static void main(String[] args) {


        List<Anime> animeList = new ArrayList(List.of(
                new Anime("Berserk", 5),
                new Anime("Demon Slayer", 25),
                new Anime("Mirai Nikky", 12)));

//        Collections.sort(animeList, (a1, a2) -> a1.getTitle().compareTo(a2.getTitle()));
        //não podemos instanciar um objeto no segundo argumento pq o que ele espera é um retorno inteiro,
        // e no compare ele possui dois argumentos, criar objeto é diferente  de utilizar a lambda
//        Collections.sort(animeList, new AnimeComparators()); erro
        animeList.sort(AnimeComparators::compareByTitle);

        System.out.println(animeList);
    }
}
