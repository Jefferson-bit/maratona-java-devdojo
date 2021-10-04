package colecoes.teste;

import colecoes.dominio.Consumidor;
import colecoes.dominio.Manga;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest02 {
    public static void main(String[] args) {

        Queue<Manga>  mangas = new PriorityQueue<>();
        mangas.add(new Manga(5L, "Pokemon", 120.0, 2));
        mangas.add(new Manga(1L, "Demon Slayer", 39.6, 3));
        mangas.add(new Manga(14L, "Hokuto no Ken", 55.9, 4));
        mangas.add(new Manga(7L, "Attack on Titan", 33.0, 6));
        mangas.add(new Manga(23L, "Dragon ball z", 44.0, 1));

        while (!mangas.isEmpty()){
            System.out.println(mangas.poll());
        }
    }
}
