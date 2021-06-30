package excecao.runtime.test;

public class RuntimeExceptionTest02 {

	public static void main(String[] args) {
		divisao(1, 0);
	}

	/**
	 * 
	 * @param a
	 * @param b n�o pode ser zero
	 * @return
	 * @throws IllegalArgumentException caso b seja zero
	 */
	
	private static int divisao(int a, int b) {
		if (b == 0 || a == 0) {
			throw new ArithmeticException("N�o pode ser dividido");
		}
		return a / b;
	}
}
