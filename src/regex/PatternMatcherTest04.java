package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest04 {
	public static void main(String[] args) {
		// \d = todos os digitos
		// \D = tudo o que n�o for digito
		// \s = traz todos os espa�os em brancos
		// \S = todos os caracteres excluindo os brancos
		// \w = tudo que for de a+z ou A+Z, todos os digitos
		// \W = traz tudo que n�o for incluso no \w
		// ? zero ou uma ocorrencia
		// * zero ou mais 
		// + uma ou mais 
		// {n,m} valor de n at� m
		// () caracter de agrupamento
		// | como se fosse a condi��o ou
		// $ representa o fim da linha
		
		String regex = "0[xX]([0-9a-fA-F])+(\\s|$)";
		String texto = "12 0x 0X 0xFFABC 0x10G 0x1";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(texto);
		System.out.println("Texto " + texto);
		System.out.println("Indice: 0123456789 ");
		System.out.println("Regex: " + regex);
		System.out.println("Posi��es encontradas: ");
		while(matcher.find()) {
			System.out.print(matcher.start() + " " + matcher.group() + "\n");
		}
		
		
	}
}
