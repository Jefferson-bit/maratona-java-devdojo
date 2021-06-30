package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteTest01 {
	public static void main(String[] args) {
		File file = new File("file.txt");
		try (FileWriter fw = new FileWriter(file)){
			fw.write("Tentando aprender java");
			System.out.println(file.getAbsoluteFile());
			//o flush força que o sistema jogue tudo do buffer, e assim que o 
			//metodo acabar o java chama a interface closeable do fileWrite
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
