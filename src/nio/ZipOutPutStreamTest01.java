package nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

//Zipando poasta quando vc ver que uma classe contem STREAM significa que ela está trabalhando com dados de baixo nivel, praticamente binarios
public class ZipOutPutStreamTest01 {
    public static void main(String[] args) {
        Path arquivoZip = Paths.get("pasta/arquivo.zip");
        Path arquivosParaZipar = Paths.get("pasta/subpasta1/subsubpasta1");
        zip(arquivoZip, arquivosParaZipar);
    }

    private static void zip(Path arquivoZip, Path arquivosParaZipar) {
        try (ZipOutputStream zipStream = new ZipOutputStream(Files.newOutputStream(arquivoZip));
             DirectoryStream<Path> directoryStream = Files.newDirectoryStream(arquivosParaZipar)) {
             for (Path file: directoryStream){
                 //mandando arquivo
                 ZipEntry zipEntry = new ZipEntry(file.getFileName().toString());
                 //coloca a próxima entrada
                 zipStream.putNextEntry(zipEntry);
                 //copiando arquivo
                 Files.copy(file, zipStream);
                 //fechando entrada
                 zipStream.closeEntry();
             }
            System.out.println("Arquivo criado com sucesso");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
