package datas.test;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalTimetest01 {
	public static void main(String[] args) {
		
		LocalTime of = LocalTime.of(23, 33, 12);
		LocalTime now = LocalTime.now();
		System.out.println(of);
		System.out.println(now);
		System.out.println(of.getHour());
		System.out.println(of.getMinute());
		System.out.println(of.getSecond());
		System.out.println(of.get(ChronoField.HOUR_OF_DAY));
		System.out.println(LocalTime.MIN);
		System.out.println(LocalTime.MAX);
	}
}
