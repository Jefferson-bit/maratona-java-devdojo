package parametrizacaocomportamento.test;

import parametrizacaocomportamento.dominio.Carro;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest01 {

    private static List<Carro> carroList = List.of(
            new Carro("Verde", 2011),
            new Carro("Preto", 1998),
            new Carro("Vermelho", 2019));

    public static void main(String[] args) {
        System.out.println(filtraCarroPorCor(carroList, "Verde"));
    }


    private static List<Carro> filtraCarroPorCor(List<Carro> carros, String cor) {
        List<Carro> carroVerde = new ArrayList<>();

        for (Carro carro : carros) {
            if (carro.getCor().equals(cor)) {
                carroVerde.add(carro);
            }
        }
        return carroVerde;
    }


}
