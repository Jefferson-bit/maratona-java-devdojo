package optional.repositorio;

import optional.dominio.Manga;

import javax.swing.text.html.Option;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MangaRepository {

    private static List<Manga> mangaList = List.of(
            new Manga(1, "Demon Slayer", 12),
            new Manga(2, "Dororo", 25)
    );

    public static Optional<Manga> findById(Integer id) {
        return findBy(manga -> manga.equals(id));
    }

    public static Optional<Manga> findByTitle(String title) {
        return findBy(manga -> manga.equals(title));
    }

    public static Optional<Manga> findBy(Predicate<Manga> predicate) {
        Manga found = null;
        for (Manga manga : mangaList) {
            if (predicate.test(manga)) {
                found = manga;
            }
        }
        return Optional.ofNullable(found);
    }

}
