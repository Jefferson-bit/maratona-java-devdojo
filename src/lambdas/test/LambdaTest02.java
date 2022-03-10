package lambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaTest02 {


    public static void main(String[] args) {
        List<String> listString = List.of("Belmond", "Relampago marquinho");
        List<Integer> integers = map(listString, s -> s.length());
        List<String> strings = map(listString, s -> s.toUpperCase());
        System.out.println(integers);
        System.out.println(strings);

    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T e : list) {
            R apply = function.apply(e);
            result.add(apply);
        }
        return result;
    }
}
