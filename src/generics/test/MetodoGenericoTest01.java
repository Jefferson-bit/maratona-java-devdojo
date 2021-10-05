package generics.test;

import generics.dominio.Barco;

import java.util.List;

public class MetodoGenericoTest01 {

    public static void main(String[] args) {
        criarArrayComUmObjeto(new Barco("Canoa marota"));
    }


    private static <T> List<T> criarArrayComUmObjeto(T t) {
        return List.of(t);
    }
}



