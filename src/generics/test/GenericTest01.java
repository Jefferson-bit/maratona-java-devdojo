package generics.test;

import java.util.ArrayList;
import java.util.List;

public class GenericTest01 {
    public static void main(String[] args) {

        //type erasure
        List<String> lista = new ArrayList<>();
        lista.add("Kamado Tanjiro");
        lista.add("Kamado Tanjiro");

        for (String s: lista){
            System.out.println(s);
        }
    }
}
