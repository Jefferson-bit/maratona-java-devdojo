package excecao.exception.test;

import java.util.Scanner;

import excecao.exception.test.dominio.LoginInvalidoException;

public class LoginInvalidoExceptionTest01 {
	
	public static void main(String[] args) {
		  try {
			logar();
		} catch (LoginInvalidoException e) {
			e.printStackTrace();
		}
	}
	
	
	private static void logar() throws LoginInvalidoException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String userName = "Goku";
		String password = "ssj";
		
		System.out.println("Usuario: ");
		String usernameDigitado = sc.nextLine();
		System.out.println("Senha ");
		String senhaDigitado = sc.nextLine();
		if(!userName.equals(usernameDigitado) ||  !password.equals(senhaDigitado)) {
			throw new LoginInvalidoException("Usuario ou Senha Invalidos");
		}
		
		System.out.println("usuario logado com sucesso ");
	}
}






