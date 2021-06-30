package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest01 {
	//buffered escreve os valores em memoria
	//enquanto fileWriter escreve em disco
	public static void main(String[] args) {
		File file = new File("file.txt");
		try (FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw)) {
			bw.write("Tentando aprender java");
			
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
