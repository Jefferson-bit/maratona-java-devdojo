package parametrizacaocomportamento.test;

import parametrizacaocomportamento.dominio.Carro;
import parametrizacaocomportamento.interfaces.CarroPredicato;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ComportamentoPorParametroTest03 {

    private static List<Carro> carroList = List.of(
            new Carro("Verde", 2011),
            new Carro("Preto", 1998),
            new Carro("Vermelho", 2019));

    public static void main(String[] args) {

        List<Carro> preto = filtra(carroList, carro -> carro.getCor().equals("Preto"));
        List<Carro> anoDoCarro = filtra(carroList, carro -> carro.getAno() < 2015);
        List<Integer> nums = List.of(1, 2, 3, 4 ,5 ,6 ,7 ,8, 9, 10);
        System.out.println(filtra(nums, num ->  num % 2 == 0));

        System.out.println(preto);
        System.out.println(anoDoCarro);
    }

    private static <T> List<T> filtra(List<T> list, Predicate<T> predicate) {
        List<T> filtraLista = new ArrayList<>();
        for (T e : list) {
            if (predicate.test(e)) {
                filtraLista.add(e);
            }
        }
        return filtraLista;
    }
}
