package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest03 {
	public static void main(String[] args) {
		// \d = todos os digitos
		// \D = tudo o que n�o for digito
		// \s = traz todos os espa�os em brancos
		// \S = todos os caracteres excluindo os brancos
		// \w = tudo que for de a+z ou A+Z, todos os digitos
		// \W = traz tudo que n�o for incluso no \w
		
		String regex = "\\d";
		String texto = "1hdhheh3g32h32h12";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(texto);
		System.out.println("Texto " + texto);
		System.out.println("Indice: 0123456789 ");
		System.out.println("Regex: " + regex);
		System.out.println("Posi��es encontradas: ");
		while(matcher.find()) {
			System.out.print(matcher.start() + "" + matcher.group()+  " " + "\n ");
		}
		
		
	}
}
