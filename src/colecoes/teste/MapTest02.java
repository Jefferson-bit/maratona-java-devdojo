package colecoes.teste;

import colecoes.dominio.Consumidor;
import colecoes.dominio.Manga;

import java.util.HashMap;
import java.util.Map;

public class MapTest02 {
    public static void main(String[] args) {
        Consumidor consumidor1 = new Consumidor("Jefferson Oliveira");
        Consumidor consumidor2 = new Consumidor("DevDojo");

       Manga manga1 = new Manga(1L, "Pokemon", 120.0);
       Manga manga2 = new Manga(2L,"Demon Slayer", 300.0);
       Manga manga3 = new Manga(3L,"Hokuto no Ken", 125.0);
       Manga manga4 = new Manga(4L,"Attack on Titan", 33.0);
       Manga manga5 = new Manga(5L,"Dragon ball z", 44.0);


       Map<Consumidor, Manga> consumidorMangaMap = new HashMap<>();

       consumidorMangaMap.put(consumidor1, manga1);
       consumidorMangaMap.put(consumidor2, manga4);

       for (Map.Entry<Consumidor, Manga> entry: consumidorMangaMap.entrySet()){
           System.out.println(entry.getKey().getNome() + ": "+ entry.getValue().getNomeDoManga());
       }


    }

}
