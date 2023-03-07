package nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class ListJavaFile extends SimpleFileVisitor<Path>  {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)  {
        if(file.getFileName().toString().endsWith(".java"))
        System.out.println(file.getFileName());
        return FileVisitResult.CONTINUE;
    }
}


//Com file visitor consegumios listar arquivos dos path um por um, mas precisamos
// de uma calsse que responde se é um file visitor
public class SimpleFileVisitorTest01 {
    public static void main(String[] args) throws IOException {
        Path root = Paths.get(".");
        Files.walkFileTree(root, new ListJavaFile());

    }
}
