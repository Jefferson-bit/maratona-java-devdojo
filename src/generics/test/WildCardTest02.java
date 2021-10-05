package generics.test;


import java.util.ArrayList;
import java.util.List;

public class WildCardTest02 {
    public static void main(String[] args) {
        List<Cachorro> cachorros =  List.of(new Cachorro(), new Cachorro());
        List<Gato> gatos =  List.of(new Gato(), new Gato());

        List<Animal> animals = new ArrayList<>();
        printConsulta1(cachorros);



    }
    private static void printConsulta(List<Animal> animals){
        for (Animal animal : animals) {
            animal.consulta();
        }
    }

    //aqui somente para leitura pq a gente não sabe quais filhos vão vim, podemos ter problema com os irmãos
    private static void printConsulta1(List<? extends Animal> animals){

        for (Animal animal : animals) {
            animal.consulta();
        }
    }
    //podemos adicionar nessa list pq temos a garantia. O polimorfismo nos garante isso
    private static void printConsulta2(List<? super Animal> animals){

        animals.add(new Cachorro());
        animals.add(new Gato());

    }
}
