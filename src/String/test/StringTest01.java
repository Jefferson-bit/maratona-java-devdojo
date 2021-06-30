package String.test;

public class StringTest01 {
	public static void main(String[] args) {
		String nome = "William"; //está no String constant pool
		String nome2 = "William";
		nome = nome.concat(" Suane");
		System.out.println(nome == nome2);
		String nome3 = new String("William"); // 1 variavel de referencia 2 ela fica no heap da memoria, e nao no poll de string
		System.out.println(nome2 == nome3);
		System.out.println(nome2 == nome3.intern());
	
		
	}
}
