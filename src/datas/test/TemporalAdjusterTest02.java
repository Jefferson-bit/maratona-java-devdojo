package datas.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

class ObterProximoDiaUtil implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal temporal) {
		DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
		int addDays;
		switch(dayOfWeek) {
			case THURSDAY: addDays = 4; break;
			case FRIDAY: addDays = 3; break;
			case SATURDAY: addDays = 2; break;
			default: addDays =1;
		}
		return temporal.plus(addDays, ChronoUnit.DAYS);
	}

}

public class TemporalAdjusterTest02 {
	public static void main(String[] args) {
		//testando dias uteis
		LocalDate now = LocalDate.now();
		System.out.println(now);
		System.out.println(now.getDayOfWeek());
		System.out.println("1-------------------1");
		now = LocalDate.now().with(new ObterProximoDiaUtil());
		System.out.println(now);
		System.out.println(now.getDayOfWeek());
		System.out.println("2-------------------2");
		now = LocalDate.now().withDayOfMonth(6).with(new ObterProximoDiaUtil());
		System.out.println(now);
		System.out.println(now.getDayOfWeek());
		System.out.println("3-------------------3");
		now = LocalDate.now().withDayOfMonth(11).with(new ObterProximoDiaUtil());
		System.out.println(now);
		System.out.println(now.getDayOfWeek());
		System.out.println("-------------------");
		now = LocalDate.now().withDayOfMonth(9).with(new ObterProximoDiaUtil());
		System.out.println(now);
		System.out.println(now.getDayOfWeek());
		System.out.println("4-------------------4");
		now = LocalDate.now().withDayOfMonth(10).with(new ObterProximoDiaUtil());
		System.out.println(now);
		System.out.println(now.getDayOfWeek());
	}
}
