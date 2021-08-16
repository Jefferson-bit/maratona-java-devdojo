package colecoes.teste;

import java.util.ArrayList;
import java.util.List;

public class ListTest01 {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList();
        List<String> nomes2 = new ArrayList();
        nomes.add("Jefferson");
        nomes.add("DevDojo ");
        nomes2.add("Oliveira");
        nomes2.add(" Academy");

        nomes.addAll(nomes2);
        for (String nome : nomes) {
            System.out.println(nomes);
        }

        nomes.add("Alex");
        for (int i = 0; i < nomes.size(); i++) {
            System.out.println(nomes.get(i));
        }

    }

}
