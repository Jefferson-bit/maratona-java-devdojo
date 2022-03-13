package streams.test;

import streams.dominio.Category;
import streams.dominio.LightNovel;
import streams.dominio.Promotion;

import java.util.*;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static streams.dominio.Promotion.NORMAL_PRICE;
import static streams.dominio.Promotion.UNDER_PROMOTION;

public class StreamTest16 {

    private static List<LightNovel> lightNovels = new ArrayList(List.of(

            new LightNovel("Berserk", 6.99, Category.FANTASY),
            new LightNovel("Dororo", 4.0, Category.DRAMA),
            new LightNovel("Demon Slayer", 3.23, Category.FANTASY),
            new LightNovel("Bleach", 3.99, Category.FANTASY),
            new LightNovel("Another", 3.52, Category.DRAMA),
            new LightNovel("One Punch Man", 7.99, Category.FANTASY),
            new LightNovel("Boku no Hero", 8.99, Category.ROMANCE)
    ));

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        long sum = 100_000_000;
        sumFor(sum);
        sumStreamIterate(sum);
        sumParallelStreamIterate(sum);
        sumLongStreamIterate(sum);
        sumLongParallelStreamIterate(sum);
    }

    private static void sumFor(long num) {
        System.out.println("sum for");
        long result = 0;
        long init = System.currentTimeMillis();
        for (int i = 1; i <= num; i++) {
            result += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }

    private static void sumStreamIterate(long num) {
        System.out.println("sum sumStreamIterate");
        long init = System.currentTimeMillis();
        long result = Stream.iterate(1L, i -> i + 1L).limit(num).reduce(0L, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }


    //nucleos
    //[1,2,3,4,5,6,7,8,9,10,11,12]
    // thread 1 é responsável por somar de 1-5
    // thread 2 é responsável por somar de 6-0
    // quando estamos iterando de um por um, fica difícil a thread saber como vai somar
    // já que não temos um tamanho definido.
    // dessa forma que estamos fazendo não é ideal trabalhar de forma paralela

    private static void sumParallelStreamIterate(long num) {
        System.out.println("sum sumParallelStreamIterate");
        long init = System.currentTimeMillis();
        long result = Stream.iterate(1L, i -> i + 1L).limit(num).parallel().reduce(0L, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }

    private static void sumLongStreamIterate(long num) {
        System.out.println("sum sumLongStreamIterate");
        long init = System.currentTimeMillis();
        long result = LongStream.rangeClosed(1L, num).reduce(0L, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }

    private static void sumLongParallelStreamIterate(long num) {
        System.out.println("sum sumLongParallelStreamIterate");
        long init = System.currentTimeMillis();
        long result = LongStream.rangeClosed(1L, num).parallel().reduce(0L, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }

    //dicas de quando usar coisas paralelas
    //- BENCHMARK (fazer alguns teste para ver o desempenho e o consumo)
    //- Unboxing | boxing isso custa na perfomance
    //- (limit, findFirst) operações que não foram feitas para trabalhar paralelamente
    //- (findAny) é bom pra utilizar em paralelo
    //- custo total da computação N, P
    //- Quantidade de dados, se for muito pequena não vale apena usar
    //- Tipos de coleções, Arraylist é bom, linkedlist não serve pq precisamos percorrer a lista inteira
    //- Tamanho do Stream(Tamanho definido são melhores)
    //- Processamento do merge: o parallel usa uma framework chamado foxjoin que seguem algumas regrinhas:
    //if(tarefa for pequena e não pode ser divida) faz sequencialmente, else
    //divide em duas tarefas, chama o mesmo método recursivamente
    //espera todas as tarefas serem completadas, combina o resultad
}
