package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

//Com eles tbm é possível deixar arquivos ocultos, somente para leitura e por ai vai
public class DosFileAttributesTest01 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("pasta/teste.txt");
        Files.createFile(path);
        //esssa sintaxe do dos: só serve para windows
        //estamos ocultando o arquivo, ou permitindo somente a leitura do mesmo
        Files.setAttribute(path, "dos:hidden", true);
        Files.setAttribute(path, "dos:readonly", true);
        Files.setAttribute(path, "dos:readonly", false);
        Files.setAttribute(path, "dos:readonly", false);

        DosFileAttributes dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);
        System.out.println(dosFileAttributes.isHidden());
        System.out.println(dosFileAttributes.isReadOnly());

        DosFileAttributeView fileAttributeView = Files.getFileAttributeView(path, DosFileAttributeView.class);
        fileAttributeView.setHidden(true);
        fileAttributeView.setReadOnly(true);

        System.out.println(fileAttributeView.readAttributes().isHidden());
        System.out.println(fileAttributeView.readAttributes().isReadOnly());
    }
}
