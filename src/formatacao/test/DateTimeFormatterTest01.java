package formatacao.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeFormatterTest01 {

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		String s1 = now.format(DateTimeFormatter.BASIC_ISO_DATE);
		String s2 = now.format(DateTimeFormatter.ISO_DATE);
		String s3 = now.format(DateTimeFormatter.ISO_LOCAL_DATE);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

		LocalDate parse1 = LocalDate.parse("20210405",DateTimeFormatter.BASIC_ISO_DATE );
		LocalDate parse2 = LocalDate.parse("2021-04-05",DateTimeFormatter.ISO_DATE );
		LocalDate parse3 = LocalDate.parse("2021-04-05",DateTimeFormatter.ISO_LOCAL_DATE );
		
		System.out.println(parse1);
		System.out.println(parse2);
		System.out.println(parse3);
		//veja a documentaçãp pois o parse transfere a string pra objeto, e a datetimeformatter e os
		//enums utilizandos, cada um oferece uma formatação diferente, caso a gente tente formatar
		//uma data com zona, e a formatação n suporta a zona, dara uma exceção e também o parse ele só formata
		// se de match com a formatação que passsamos, ou seja, precisava passar a formtação do enum junto com o parse
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.GERMAN);
		String format = LocalDate.now().format(ofPattern);
		System.out.println(format);
		
		LocalDate parse = LocalDate.parse("05.April.2021", ofPattern);
		System.out.println(parse);
	}
	
}
