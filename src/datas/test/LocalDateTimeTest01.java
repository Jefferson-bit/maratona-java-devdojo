package datas.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeTest01 {
	public static void main(String[] args) {
		
		LocalDateTime dateTime = LocalDateTime.now();
		LocalDate date = LocalDate.parse("2022-01-08");
		LocalTime time = LocalTime.now();
		LocalDateTime atTime = date.atTime(time);
		System.out.println(dateTime);
		System.out.println(atTime);
		
	}
}
