package nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class ListAllFiles extends SimpleFileVisitor<Path>  {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)  {
        System.out.println(file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    //ele é invocado quando ele entra em um diretorio, qunadl ele entra ele imprime
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("pre visit " + dir.getFileName().toString());
        return FileVisitResult.CONTINUE;
    }

    //se ELE tentar ler um arquivo de leitura e n tiver permissão ou qualquer tipo de problema
    //ele lança uma exceção. Então pode user ele pra teratar algo, lag e tals
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return super.visitFileFailed(file, exc);
    }

    //previsitor é quando vc tá entrando,e o postvisitor é quando vc tá saindo
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("post visit " + dir.getFileName().toString());
        return FileVisitResult.CONTINUE;
    }
}

public class SimpleFileVisitorTest02 {
    public static void main(String[] args) throws IOException {
        Path root = Paths.get("pasta");
        Files.walkFileTree(root, new ListAllFiles());

    }
}
