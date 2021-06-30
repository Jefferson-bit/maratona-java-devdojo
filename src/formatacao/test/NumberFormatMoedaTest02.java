package formatacao.test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatMoedaTest02 {
	public static void main(String[] args) {

		Locale locale = Locale.getDefault();
		Locale localeJP = Locale.JAPAN;
		Locale localeIt = Locale.ITALY;
		Locale localeUs = Locale.US;

		NumberFormat[] instance = new NumberFormat[4];
		instance[0] = NumberFormat.getCurrencyInstance(locale);
		instance[1] = NumberFormat.getCurrencyInstance(localeJP);
		instance[2] = NumberFormat.getCurrencyInstance(localeIt);
		instance[3] = NumberFormat.getCurrencyInstance(localeUs);
		double valor = 1_000.2130;
		for (NumberFormat format : instance) {
			format.getMaximumFractionDigits();
			System.out.println(format.format(valor));
		}

		String valorString = "$1,000.2130";
		try {
			System.out.println(instance[3].parse(valorString));// Nesse caso que estamos trabalhando com moeda
			//tomar cuidado pois, estou pegando um valor monetario USA no meu Vetor, e o parse fara o parse
			//somente da moeda USA
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
