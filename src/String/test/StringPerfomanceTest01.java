package String.test;

public class StringPerfomanceTest01 {
	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		concatString(30_000);
		long fim = System.currentTimeMillis();
		System.out.println("Tempo gasto para String " + (fim - inicio) + " ms");
		
		System.out.println("------------------------------");
		
		inicio = System.currentTimeMillis();
		concatStringBuilder(1_000_000);
		fim = System.currentTimeMillis();
		System.out.println("Tempo gasto para StringBuilder " + (fim - inicio) + " ms");
		
		System.out.println("------------------------------");
		
		inicio = System.currentTimeMillis();
		concatStringBuffer(1_000_000);
		fim = System.currentTimeMillis();
		System.out.println("Tempo gasto para StringBuffer " + (fim - inicio) + " ms");
	}
	
	private static void concatString(int tamanho) {
		@SuppressWarnings("unused")
		String texto = " ";
		for (int i = 0; i < tamanho; i++) {
			texto += i;
		}
	}

	
	private static void concatStringBuilder(int tamanho) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tamanho; i++) {
			sb.append(i);
		}
	}

	
	private static void concatStringBuffer(int tamanho) {
	
		StringBuffer stb = new StringBuffer();
		for (int i = 0; i < tamanho; i++) {
			stb.append(i);
		}
	}
}
