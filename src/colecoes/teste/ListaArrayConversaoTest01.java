package colecoes.teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaArrayConversaoTest01 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.toArray();
        Integer[] numerosArray = numeros.toArray(new Integer[0]);
        System.out.println(Arrays.toString(numerosArray));

        numerosArray[0] = 1;
        numerosArray[1] = 2;
        numerosArray[2] = 3;

        //esse arrays.asList cria um link com o nosso array em cima
        //sendo assim não podemos adicionar ou remover
        List<Integer> arrayToList = Arrays.asList(numerosArray);
        arrayToList.set(0, 12);
        System.out.println(Arrays.toString(numerosArray));
        System.out.println(arrayToList);
        System.out.println("-------------------------");
        //aqui podemos adicionar ou remover
        ArrayList<Integer> numerosList  = new ArrayList<>(Arrays.asList(numerosArray));
        numerosList.add(15);
        System.out.println(numerosList);
    }
}
