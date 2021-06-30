package excecao.exception.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import excecao.exception.test.dominio.Leitor1;
import excecao.exception.test.dominio.Leitor2;

public class TryWithResource01 {
	public static void main(String[] args) {
		lerArquivo();
	}
	
	public static void lerArquivo() {
		try (Leitor1 leitor1 = new Leitor1();
			 Leitor2 leitor2 = new Leitor2()) {
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void lerArquivo2 () {
		Reader reader = null;
		try {
			reader = new BufferedReader(new FileReader("teste.txt"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
