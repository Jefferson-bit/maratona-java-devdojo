package generics.test;

import generics.dominio.Barco;
import generics.dominio.Carro;
import generics.service.BarcoRentavelService;
import generics.service.RentalService;

import java.util.ArrayList;
import java.util.List;

public class ClasseGenericaTest03 {

    public static void main(String[] args) {
        List<Carro> carros = new ArrayList<>(List.of(new Carro("BMW"), new Carro("Mercedes")));
        List<Barco> barcos = new ArrayList<>(List.of(new Barco("Lancha"), new Barco("Canoa")));
        RentalService<Carro> rentalService = new RentalService<>(carros);

        Carro carro = rentalService.buscarObjetoDisponivel();
        System.out.println("Usando carro por um mês");
        rentalService.retornarObjetoAlugado(carro);



    }
}
