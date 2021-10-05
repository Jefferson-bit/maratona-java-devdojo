package generics.service;

import generics.dominio.Barco;

import java.util.ArrayList;
import java.util.List;

public class BarcoRentavelService {

    private List<Barco> barcos = new ArrayList<>(List.of(new Barco("Lancha"), new Barco("Canoa")));

    public Barco buscarBarcoDisponivel(){
        System.out.println("Buscando Barco disponivel");
        Barco barco = barcos.remove(0);
        System.out.println("Alugando Barco: " + barco);
        System.out.println("Barcos disponiveis para alugar:");
        System.out.println(barcos);
        return barco;
    }

    public void retornarBarcoAlugado(Barco barco){
        System.out.println("Devolvendo Barco: " + barco);
        barcos.add(barco);
        System.out.println("Barcos disponiveis para alugar: " + barcos);

    }

}
