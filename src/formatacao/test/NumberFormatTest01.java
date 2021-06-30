package formatacao.test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest01 {
	public static void main(String[] args) {
		
		Locale locale = Locale.getDefault();
		Locale localeJP = Locale.JAPAN;
		Locale localeIt = Locale.ITALY;
		Locale localeUs = Locale.US;
		
		NumberFormat[] instance  = new NumberFormat[4];
		instance[0] = NumberFormat.getInstance(locale);
		instance[1] = NumberFormat.getInstance(localeJP);
		instance[2] = NumberFormat.getInstance(localeIt);
		instance[3] = NumberFormat.getInstance(localeUs);
		double valor = 100_000_000.2130;
		for(NumberFormat numberFormat: instance) {
			System.out.println(numberFormat.getMaximumFractionDigits());//pega a ultimas casas decimais de cada país
			System.out.println(numberFormat.format(valor));
		}
		
		String valorString = "1_000.2130";
		try {
			System.out.println(instance[0].parse(valorString));//se houver caracter especiais no parse
			//ele vai ignorar o restantes das casas decimais, e só vai imprimir o numero 1 no exemplo
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
