package excecao.exception.test.dominio;

public class LoginInvalidoException extends Exception{
	private static final long serialVersionUID = 1L;

	public LoginInvalidoException(String message) {
		super(message);
		
	}
	
	public LoginInvalidoException() {
		super("Login Invalido");
		
	}
	
}
