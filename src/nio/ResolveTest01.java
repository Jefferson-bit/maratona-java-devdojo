package nio;

import java.nio.file.Path;
import java.nio.file.Paths;

//Função do resolve é fazera  função de paths distinto. Caso vc n tenha ele completo é juntar tudo
public class ResolveTest01 {

    public static void main(String[] args) {
        Path dir = Paths.get("home/william");
        Path arquivo = Paths.get("dev/arquivo.txt");
        Path resolve = dir.resolve(arquivo);
        System.out.println(resolve);


        Path absoluto = Paths.get("/home/william");
        Path relativo = Paths.get("dev");
        Path file = Paths.get("file.txt");

        System.out.println("1 " + absoluto.resolve(relativo));
        System.out.println("2 " + absoluto.resolve(file));
        //no caso do 3 o path ele vai retornar o path absoluto pq já é o caminho absoluto, então n tem nada para resolver
        System.out.println("3 " + relativo.resolve(absoluto));
        System.out.println("4 " + relativo.resolve(file));
    }
}
