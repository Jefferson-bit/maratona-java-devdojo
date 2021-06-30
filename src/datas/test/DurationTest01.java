package datas.test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DurationTest01 {

	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime nowAfterTwotYears = LocalDateTime.now().plusYears(2).plusMinutes(8);
		LocalTime time = LocalTime.now();
		LocalTime timeMinus7Hours = LocalTime.now().minusHours(7);
		Duration d1 = Duration.between(now, nowAfterTwotYears);
		Duration d2 = Duration.between(time, timeMinus7Hours);
		Duration d3 = Duration.between(Instant.now(), Instant.now().plusSeconds(1000));
		Duration d4 = Duration.ofDays(20);
		Duration d5 = Duration.ofMinutes(3);
		
		//A Classe Duration ela da suporte somente para classe que suporta segundos e nanoSegundos
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
		System.out.println(d4);
		System.out.println(d5);
		
		
	}	

}
