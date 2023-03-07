package nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest01 {
	
	public static void main(String[] args) {
		//A implementação do path é baseado no sistema operacional que você está utilizando
		Path path = Paths.get("C:\\eclipse\\javacore\\pasta2\\arquivo.txt");
		Path path1 = Paths.get("C:\\eclipse\\javacore\\pasta2\\", "arquivo.txt");
		Path path2 = Paths.get("C", "\\eclipse\\javacore\\pasta2\\arquivo.txt");
		
		Path path3 = Paths.get("C", "eclipse", "javacore", "pasta2" ,"arquivo.txt");
		System.out.println(path.getFileName());
		System.out.println(path1.getFileName());
		System.out.println(path2.getFileName());
		System.out.println(path3.getFileName());
		
	}
}
