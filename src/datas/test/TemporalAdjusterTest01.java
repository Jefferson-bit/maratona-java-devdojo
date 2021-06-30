package datas.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjusterTest01 {
	
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		
		date = date.with(ChronoField.DAY_OF_MONTH, 5);
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
		System.out.println("-----------------");
		date = LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
		System.out.println("-----------------");
		date = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
		System.out.println("-----------------");
		date = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
		System.out.println("-----------------");
		date = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
		System.out.println("-----------------");
		date = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
		System.out.println("-----------------");
		date = LocalDate.now().with(TemporalAdjusters.firstDayOfYear());
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
	}
}
