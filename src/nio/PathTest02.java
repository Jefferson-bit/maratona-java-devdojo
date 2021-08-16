package nio;

import junit.runner.StandardTestSuiteLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest02 {

    public static void main(String[] args) throws IOException {
        Path pastaPah = Paths.get("pasta");
        if(Files.notExists(pastaPah)) {
            //createDirectory lança uma exceção caso a pasta já exista
            Path pastaDirectory = Files.createDirectory(pastaPah);
        }

        Path subPastaPath = Paths.get("pasta/subpasta/subsubpasta");
        Path directories = Files.createDirectories(subPastaPath);
        Path filePath = Paths.get(subPastaPath.toString(), "file.txt");
        if(Files.notExists(pastaPah)) {
            Files.createFile(filePath);
        }
        //origem
        Path source = filePath;
        //destino
        Path target = Paths.get(filePath.getParent().toString() , "file_renamed.txt");
        Files.copy(source, target);
    }
}
