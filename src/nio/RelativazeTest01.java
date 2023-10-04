package nio;

import java.nio.file.Path;
import java.nio.file.Paths;


//relativa um diretorio path. Dado dois Paths
// como chega no path2 apartir do path1, caso vc tenha dois path
// pra ficar um pouco mais claro, basicamente como vc no diretorio atual faz pra chegar em outro
// exemplo: pwd diz q estou no diretorio /home/jefferson mas eu quero chegar em /devdojo/OlaMundo.java
// então vc faz dir.relativize(diretorio-quevc-quer-chegar) e ele vai retorna um path com /devdojo/OlaMundo.java
public class RelativazeTest01 {
    public static void main(String[] args) {
        Path dir = Paths.get("/home/jefferson");
        Path clazz = Paths.get("/home/jefferson/devdojo/OlaMundo.java");
        Path pathToClazz = dir.relativize(clazz);
        System.out.println(pathToClazz);

        Path absoluto1 = Paths.get("/home/jefferson");
        Path absoluto2 = Paths.get("/usr/local");
        Path absoluto3 = Paths.get("/home/jefferson/devdojo/OlaMundo.java");
        Path relativo1 = Paths.get("temp");
        Path relativo2 = Paths.get("temp/temp.2021921");

        System.out.println("1 " + absoluto1.relativize(absoluto3));
        System.out.println("2 " + absoluto3.relativize(absoluto1));
        System.out.println("3 " + absoluto1.relativize(absoluto2));
        System.out.println("4 " + relativo1.relativize(relativo2));
        //java lança uma exceção pq ele n sabe como chegar no temp pq ele é um caminho relativo
        //então tome cuidado ao misturar absolute path com relative
        System.out.println("5 " + absoluto1.relativize(relativo1));


    }
}
