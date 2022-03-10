package lambdas.test;

import java.util.List;
import java.util.function.Consumer;

public class LambdaTest01 {

    public static void main(String[] args) {

        List<String> listString = List.of("Vegeta", "Gon", "Killua");

        forEach(listString, consumerString -> System.out.println(consumerString));
        forEach(listString, consumerInteger -> System.out.println(consumerInteger));

    }


    private static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T e : list) {
            consumer.accept(e);
        }
    }
}
