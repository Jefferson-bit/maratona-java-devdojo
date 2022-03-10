package parametrizacaocomportamento.test;

import parametrizacaocomportamento.dominio.Carro;
import parametrizacaocomportamento.interfaces.CarroPredicato;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest02 {

    private static List<Carro> carroList = List.of(
            new Carro("Verde", 2011),
            new Carro("Preto", 1998),
            new Carro("Vermelho", 2019));

    public static void main(String[] args) {

        List<Carro> preto = filtra(carroList, carro -> carro.getCor().equals("Preto"));
        List<Carro> anoDoCarro = filtra(carroList, carro -> carro.getAno() < 2015);



        List<Carro> verde = filtra(carroList, new CarroPredicato() {
            @Override
            public boolean test(Carro carro) {
                return carro.getCor().equals("Verde");
            }
        });

        System.out.println(verde);
        System.out.println(preto);
        System.out.println(anoDoCarro);
    }


    private static List<Carro> filtra(List<Carro> carros, CarroPredicato carroPredicato) {
        List<Carro> filtraCarro = new ArrayList<>();

        for (Carro carro : carros) {
            if (carroPredicato.test(carro)){
                filtraCarro.add(carro);
            }
        }
        return filtraCarro;
    }

}
