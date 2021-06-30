package datas.test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.JapaneseDate;
import java.util.Map;

public class ZoneIdTest01 {
	public static void main(String[] args) {
		Map<String, String> shortIds = ZoneId.SHORT_IDS;
		System.out.println(shortIds);
		System.out.println(ZoneId.systemDefault());
		ZoneId asiaTokyo = ZoneId.of("Asia/Tokyo");
		System.out.println(asiaTokyo);
		
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		ZonedDateTime atZone = now.atZone(asiaTokyo);
		System.out.println(atZone);
		
		Instant nowIsntant = Instant.now();
		System.out.println(nowIsntant);
		ZonedDateTime atZoneInstant = nowIsntant.atZone(asiaTokyo);
		System.out.println(atZoneInstant);
		
		System.out.println(ZoneOffset.MIN);
		System.out.println(ZoneOffset.MAX);
		
		ZoneOffset offSetManaus = ZoneOffset.of("-04:00");
		OffsetDateTime atOffset = now.atOffset(offSetManaus);
		System.out.println(atOffset);
		
		JapaneseDate from = JapaneseDate.from(LocalDate.now());
		
		System.out.println(from);
	}
}
