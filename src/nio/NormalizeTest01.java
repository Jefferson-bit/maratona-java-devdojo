package nio;

import java.nio.file.Path;
import java.nio.file.Paths;

//basicamente ele normaliza os path quando se tem . ou ..
public class NormalizeTest01 {

    public static void main(String[] args) {
        String diretorioProjeto = "home/jefferson/dev";
        String arquivoTxt = "../../arquivo.txt";

        Path path1 = Paths.get(diretorioProjeto, arquivoTxt);
        System.out.println(path1);
        System.out.println(path1.normalize());
        Path path2 = Paths.get("/home/./jefferson/./dev/");
        System.out.println(path2);
        System.out.println(path2.normalize());
    }
}
