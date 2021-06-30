package datas.test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LocalTest01 {

	public static void main(String[] args) {
		Locale localeItaly = new Locale("it", "IT");
		Locale localeCH = new Locale("it", "CH");
		Locale localeJP = new Locale("ja", "JP");
		Locale localeHolanda = new Locale("nl", "NL");
		
		Calendar calendar = Calendar.getInstance();
		DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL, localeItaly);
		DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL, localeCH);
		DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL, localeJP);
		DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL, localeHolanda);
		
		System.out.println("Italia " + df1.format(calendar.getTime()));
		System.out.println("Suiça " + df2.format(calendar.getTime()));
		System.out.println("Japão " + df3.format(calendar.getTime()));
		System.out.println("Holanda " + df4.format(calendar.getTime()));
		
		System.out.println(localeItaly.getDisplayCountry(localeCH));
		System.out.println(localeCH.getDisplayCountry(localeJP));
		System.out.println(localeCH.getDisplayCountry(localeHolanda));
	}

}
