package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest05 {
	@SuppressWarnings("unused")
	private static Matcher matcher2;

	public static void main(String[] args) {
		// \d = todos os digitos
		// \D = tudo o que não for digito
		// \s = traz todos os espaços em brancos
		// \S = todos os caracteres excluindo os brancos
		// \w = tudo que for de a+z ou A+Z, todos os digitos
		// \W = traz tudo que não for incluso no \w
		// ? zero ou uma ocorrencia
		// * zero ou mais ocorrencia
		// + uma ou mais ocorrencia
		// {n,m} valor de n até m
		// () caracter de agrupamento
		// [] chamado de range
		// | como se fosse a condição OU
		// $ representa o fim da linha
		// . = ele vai achar 1.3 123. 1.3.3 tudo que puder ter caracter especiais coringa
		String regex = "([a-zA-Z0-9\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";
		String texto = "luffy@hotmail.com, 123jotaro@gmail.com, #@!zoro@mail.br, teste@gmail.com.br, sakura@mail.com";
		System.out.println("Email valido");
		System.out.println("zoro@mail.br".matches(regex));
		System.out.println(texto.split(",")[1].trim());
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(texto);
		System.out.println("Deu valor");
		System.out.println("");
		System.out.println("Texto " + texto);
		System.out.println("Indice: 0123456789 ");
		System.out.println("Regex: " + regex);
		System.out.println("Posições encontradas: ");
		while(matcher.find()) {
			System.out.print(matcher.start() + " " + matcher.group() + "\n");
		}
		String texto2 = "luffy@hotmail.com, 123jotaro@gmail.com, #@!zoro@mail.br, teste@gmail.com.br, sakura@mail";
		System.out.println("Texto 2 "+texto2);
		texto2 = texto2.replaceAll("\\W \\d", "");
		System.out.println("Texto 2 "+texto2);
	}
}
