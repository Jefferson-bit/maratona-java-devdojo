package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesTest01 {

    public static void main(String[] args) throws IOException {

        Path pastaPah = Paths.get("pasta");
        //criando uma pasta no diretorio raiz
        if(Files.notExists(pastaPah)) {
            //createDirectory lança uma exceção caso a pasta já exista
            Path pastaDirectory = Files.createDirectory(pastaPah);
        }

        Path subPastaPath = Paths.get("pasta/subpasta/subsubpasta");
        //created directories não lança exceção caso já exista, caso n exista ele cria
        Path directories = Files.createDirectories(subPastaPath);
        Path filePath = Paths.get(subPastaPath.toString(), "file.txt");
        //criando arquivo
        if(Files.notExists(pastaPah)) {
            Files.createFile(filePath);
        }
        //origem
        Path source = filePath;
        //destino
        Path target = Paths.get(filePath.getParent().toString() , "file_renamed.txt");
        Files.copy(source, target);
        //replace_existing ele da um replace, evitando uma esxceção caso o arquivo exista
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
    }
}
