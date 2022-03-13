package optional.teste;

import optional.dominio.Manga;
import optional.repositorio.MangaRepository;

import java.util.Optional;

public class OptionalTest02 {

    public static void main(String[] args) {


        Optional<Manga> dororo = MangaRepository.findBy(manga -> manga.getTitle().equals("Dororo"));
        dororo.ifPresent(manga -> manga.setTitle("Dororo 2"));
        System.out.println(dororo);

        Manga manga1 = MangaRepository.findBy(manga -> manga.getTitle().equals("Drifters")).orElse(new Manga(12, "Drifeters", 22));
        System.out.println(manga1);

        MangaRepository.findBy(manga -> manga.getId().equals(3)).orElseThrow(IllegalArgumentException::new);
    }
}
