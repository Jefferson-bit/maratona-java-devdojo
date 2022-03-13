package streams.test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class StreamTest10 {

    public static void main(String[] args) {


        //iterate vc precisa de um seed inicial
        //unaryOperator  ele retorna  o que a gente passo como argumento, seja iinteiro ou double no seed
        Stream.iterate(1, n -> n + 2)
                .limit(5)
                .forEach(System.out::println);

        // (0,1), (1,1), (1,2), (2,3), (3,5), (5,8)

        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(7)
                .forEach(a -> System.out.println(Arrays.toString(a)));

        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(7)
                .map(a -> a[0])
                .forEach(System.out::println);

        ThreadLocalRandom random = ThreadLocalRandom.current();

        Stream.generate(() -> random.nextInt(1, 500)).limit(15).forEach(System.out::println);
    }
}
