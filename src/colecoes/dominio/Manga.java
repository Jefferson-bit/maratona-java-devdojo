package colecoes.dominio;

import java.util.Objects;

public class Manga implements Comparable<Manga> {

    private Long id;
    private String nomeDoManga;
    private double preco;

    public Manga(Long id, String nomeDoManga, double preco) {
        this.id = id;
        this.nomeDoManga = nomeDoManga;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDoManga() {
        return nomeDoManga;
    }

    public void setNomeDoManga(String nomeDoManga) {
        this.nomeDoManga = nomeDoManga;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manga manga = (Manga) o;
        return Double.compare(manga.preco, preco) == 0 && Objects.equals(id, manga.id) && Objects.equals(nomeDoManga, manga.nomeDoManga);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeDoManga, preco);
    }

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", nomeDoManga='" + nomeDoManga + '\'' +
                ", preco=" + preco +
                '}';
    }

    @Override
    public int compareTo(Manga other) {
        //retorna negativo se o this < other
        // se this == other, retorna 0
        //positivo se o this > other
//        if (this.id < other.getId()) {
//            return -1;
//        } else if (this.id.equals(other.getId())) {
//            return 0;
//        } else {
//            return 1;
//        }

        return Double.compare(preco, other.getPreco());
//        return this.id.compareTo(other.getId());
    }
}
