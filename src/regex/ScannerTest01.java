package regex;

public class ScannerTest01 {
	
	public static void main(String[] args) {
		String texto = "Levi, Eren, Mikasa, true, 200";
		String[] split = texto.split(",");
		for (String string : split) {
			System.out.println(string.trim());
		}
	}
}
