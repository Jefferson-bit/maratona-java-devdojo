package generics.test;

import generics.dominio.Barco;
import generics.dominio.Carro;
import generics.service.BarcoRentavelService;
import generics.service.CarroRentavelService;

public class ClasseGenericaTest02 {

    public static void main(String[] args) {
        BarcoRentavelService barcoRentavelService = new BarcoRentavelService();
        Barco barco = barcoRentavelService.buscarBarcoDisponivel();
        System.out.println("Usando carro por 1 mês...");
        barcoRentavelService.retornarBarcoAlugado(barco);


    }
}
