package streams.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest05 {

    public static void main(String[] args) {
        List<String> words = List.of("Jo", "Ken", "Pu");
        String[] split = words.get(0).split("");
        System.out.println(Arrays.toString(split));


        List<String> j = List.of("J", "O", "K", "E", "N", "P", "U");

        System.out.println(j);
        Stream<String> stream = Arrays.stream(split);

        List<String> collect = words.stream()
                // retorna um Stream<String[]>
                .map(w -> w.split(""))
                // retorna um Stream<String>
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());

        System.out.println(collect);


    }
}
