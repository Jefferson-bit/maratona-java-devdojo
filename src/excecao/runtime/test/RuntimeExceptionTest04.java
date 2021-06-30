package excecao.runtime.test;

import java.io.IOException;
import java.sql.SQLException;

public class RuntimeExceptionTest04 {
	public static void main(String[] args) {
		try {
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Dentro do ArrayIndexOutOfBoundsException ");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Dentro do IndexOutOfBoundsException ");
		} catch (IllegalArgumentException e) {
			System.out.println("Dentro do IllegalArgumentException ");
		} catch (ArithmeticException e) {
			System.out.println("Dentro do ArithmeticException ");
		} 
		try {
			talvezLanceException();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	private static void talvezLanceException () throws SQLException, IOException {
		
	}
}
