package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest02 {
	public static void main(String[] args) {
		// \d = todos os digitos
		// \D = tudo o que não for digito
		// \s = traz todos os espaços em brancos
		// \S = todos os caracteres excluindo os brancos
		// \w = tudo que for de a+z ou A+Z, todos os digitos
		// \W = traz tudo que não for incluso no \w
		// [] = busca as 
		String regex = "0[xX][0-9a-fA-F]";
		String texto = "12 0x 0X 0xFFABC 0x109 0x1";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(texto);
		System.out.println("Texto " + texto);
		System.out.println("Indice: 0123456789 ");
		System.out.println("Regex: " + regex);
		System.out.println("Posições encontradas: ");
		while(matcher.find()) {
			System.out.print(matcher.start() + " " + matcher.group()+ "\n");
		}
		
		int numerosHexaDecimais = 0x59F86A; //para usar numeros hexadecimais.  precisa colocar 0x
		// não pode passar da letra F
		System.out.println(numerosHexaDecimais);
	}
}
