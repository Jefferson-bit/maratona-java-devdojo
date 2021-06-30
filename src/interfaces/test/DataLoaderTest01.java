package interfaces.test;

import interfaces.dominio.DatabaseLoader;
import interfaces.dominio.FileLoader;

public class DataLoaderTest01 {

	public static void main(String[] args) {
		DatabaseLoader databaseLoader = new DatabaseLoader();
		FileLoader fileLoader = new FileLoader();
		databaseLoader.load();
		databaseLoader.remove();
		fileLoader.load();
		fileLoader.remove();
	}
}
