package colecoes.teste;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest01 {

    public static void main(String[] args) {
        //first in, first out caracteristica de fila, primeiro a entra, primeiro a sair
        //novamente, queue também precisa de um comparable

        Queue<String> fila = new PriorityQueue<>();
        fila.add("C");
        fila.add("B");
        fila.add("A");

        for (String s : fila) {
            System.out.println(s);
        }
        System.out.println(fila);
        //mostra primeiro elemento
        fila.peek();

        fila.poll();

    }
}
