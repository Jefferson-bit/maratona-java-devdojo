package io;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;

public class FileTest01 {
	public static void main(String[] args) throws IOException {
		 File file = new File("file.txt");
		 boolean isCreated = file.createNewFile();
		 System.out.println("Criando arquivo "+isCreated);
		 System.out.println("Caminho do arquivo "+file.getPath());
		 System.out.println("Caminha absoluto do arquivo " +file.getAbsolutePath());
		 System.out.println("É um diretorio? " +file.isDirectory());
		 System.out.println("É um arquivo? " +file.isFile());
		 System.out.println("Esta oculto? " +file.isHidden());
		 System.out.println("Quando ele foi modificado? " + 
		 Instant.ofEpochMilli((file.lastModified())).atZone(ZoneId.systemDefault()));
		 if(file.exists()) {
			 boolean isDelete = file.delete();
			 System.out.println(isDelete);
		 }
		 
	}

}
