package nio;

import java.nio.file.*;

//Foi criado para facilitar a busca de paths
//basicamente usando expressões regulares para pegar caminhos, por exemplo main.java
//vc usa main* então ele pega algo qualquer coisa depois do asteristico
public class PathMatcherTest01 {

    public static void main(String[] args) {
        Path path1 = Paths.get("pasta/subpasta/file.bkp");
        Path path2 = Paths.get("pasta/subpasta/file.txt");
        Path path3 = Paths.get("pasta/subpasta/file.java");

        matches(path1, "glob:*.bkp");
        matches(path1, "glob:**/*.bkp");
        //as chaves indica que ele vai buscar os arquivos especificado dentro das chaves
        matches(path1, "glob:**/*.{bkp,java,txt}");
        matches(path2, "glob:**/*.{bkp,java,txt}");
        matches(path3, "glob:**/*.{bkp,java,txt}");
        // as interrogações diz para buscar arquivo que depois do ponto tenha três letras
        matches(path1, "glob:**/*.???");
        matches(path2, "glob:**/*.???");
        matches(path3, "glob:**/*.???");
        matches(path3, "glob:**/file.????");



    }

    private static void matches(Path path, String glob){
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob + ": " +matcher.matches(path));
    }
}
