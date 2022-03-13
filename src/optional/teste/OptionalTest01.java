package optional.teste;

import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Optional;

public class OptionalTest01 {

    public static void main(String[] args) {

        Optional<String> o1 = Optional.of("Salve");
        Optional<Object> o2 = Optional.ofNullable(null);
        Optional<Object> empty = Optional.empty();

        //dara nullPointer
//        String name = findName("rodrigo");
//        System.out.println(name.toUpperCase());

        System.out.println(o1);
        System.out.println(o2);
        System.out.println(empty);

        Optional<String> namesOptional = findName("odrigo");
        namesOptional.ifPresent(s -> System.out.println(s.toUpperCase()));

    }


    //Optional não é indica pra passagem de paramentro
    // também não é recomendado usar como variavel de classe, ela não é uma classe serializavel
    //Hibernate/JPÀ esperam que os objetos sejam serializaveis
    private static Optional<String> findName(String name) {

        List<String> list = List.of("Rodrigo", "Romilson");

        int i = list.indexOf(name);

        if (i >= 1) {
            System.out.println("Tem");
            return Optional.of(list.get(i));
        }
        System.out.println("Vazio");
        return  Optional.empty();
    }
}
