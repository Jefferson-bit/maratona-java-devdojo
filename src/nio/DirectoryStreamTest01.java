package nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//É uma forma de pegar todos os arquivos de um diretorio. Ele funciona como DIR do windows
//DIR lista apenas o primeiro level de pasta e arquivos
public class DirectoryStreamTest01 {

    public static void main(String[] args) {
        Path dir = Paths.get(".");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            //listando todos os arquivos de um diretorio, porém não entra nos path
            for(Path path: stream){
                System.out.println(path.getFileName());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
