package excecao.runtime.test;

import java.util.Optional; 

public class RuntimeExceptionTest03 {
	public static void main(String[] args) {
		
		Optional<String> optional = Optional.of("");
		System.out.println("A String é: " + optional.orElse(alternativeString()));
		System.out.println("----------------------------------------");
		Optional<Integer> number = Optional.of(10);
		System.out.println("The number is: " + number.orElseGet(() -> alternativeNumber()));
	
		try {
			System.out.println("Abrindo arquivo");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Fechando recurso liberado pelo sistema operacional");
		}
	}
	
	private static String alternativeString() {
	    String number = "Salve";
	    System.out.println("The alternative number is: " + number);
	    return number;
	}
	
	private static Integer alternativeNumber() {
	    int number = 747;
	    System.out.println("The alternative number is: " + number);
	    return number;
	}
}
