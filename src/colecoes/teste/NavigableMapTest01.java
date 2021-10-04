package colecoes.teste;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapTest01 {

    public static void main(String[] args) {

        //nesse caso aqui, a ordenação é por chave, o comparable or compara
        NavigableMap<String, String> map = new TreeMap<>();
        map.put("A", "Lentra A");
        map.put("B", "Lentra B");
        map.put("C", "Lentra C");
        map.put("D", "Lentra D");
        map.put("E", "Lentra E");

        for (Map.Entry<String, String> entry: map.entrySet()){
            System.out.println(entry.getKey()+"-"+entry.getValue());

        }
        //retorna todos que vem antes da letra C
        System.out.println(map.headMap("C"));

    }
}
