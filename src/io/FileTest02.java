package io;

import java.io.File;
import java.io.IOException;

public class FileTest02 {
	
	public static void main(String[] args) throws IOException {
		File fileDiretorio = new File("pasta");
		boolean mkdir = fileDiretorio.mkdir();
		System.out.println("Pasta criada?: "+mkdir);
		
		File fileArquivoDiretorio = new File(fileDiretorio,"arquivo.txt");
		boolean fileArquivoCriado = fileArquivoDiretorio.createNewFile();
		System.out.println("Arquivo.txt criado?: "+ fileArquivoCriado);
		
		File fileRenamed = new File(fileDiretorio,"arquivo_renomeado.txt");
		boolean isRenamed = fileArquivoDiretorio.renameTo(fileRenamed);
		System.out.println("Arquivo txt renomeado?: "+ isRenamed);
		
		File fileDiretorioRenomeado = new File("pasta2");
		fileDiretorio.renameTo(fileDiretorioRenomeado);
		System.out.println("Diretorio pasta renomeado?: " +isRenamed);
	}
}
