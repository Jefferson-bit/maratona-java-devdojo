package datas.test;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodTest01 {

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		LocalDate nowAfterTwotYears = LocalDate.now().plusYears(2).plusDays(7);
		Period p1 = Period.between(now, nowAfterTwotYears);
		Period p2 = Period.ofDays(10);
		Period p3 = Period.ofWeeks(58);
		Period p4 = Period.ofMonths(3);
		Period p5 = Period.ofYears(3);
		Period p6 = Period.ofDays(365);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		System.out.println(p5);
		System.out.println(p6);
		System.out.println(p3.getMonths());//ira retornar zero ele nao retorna a quantidade de meses apartir da quantidade
		//de dias que voce tem
		System.out.println("----------");
		System.out.println(Period.between(now, now.plusDays(p3.getDays())).getMonths());

		System.out.println(now.until(now.plusDays(p3.getDays()), ChronoUnit.MONTHS));
		//retornando dias da semana em meses, serve para as gravidas que falam q estao de 40 semanas
	}
}
