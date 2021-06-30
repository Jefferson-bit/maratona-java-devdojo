package datas.test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class ChronoUnitTest01 {

	public static void main(String[] args) {
		LocalDateTime aniversario = LocalDateTime.of(1998, Month.NOVEMBER, 28, 12,0,0);
		System.out.println("Quantidade de dias que ja vivi " +ChronoUnit.DAYS.between(aniversario, LocalDateTime.now()));//o que eu tenho de vida em dias
		System.out.println("Quantidade de semanas que ja vivi " +ChronoUnit.WEEKS.between(aniversario, LocalDateTime.now()));//o que eu tenho de vida em semanas
		System.out.println("Quantidade de meses que ja vivi " +ChronoUnit.MONTHS.between(aniversario, LocalDateTime.now()));//o que eu tenho de vida em meses
		System.out.println("Quantidade de anos que ja vivi " +ChronoUnit.YEARS.between(aniversario, LocalDateTime.now()));//o que eu tenho de vida em year
		
	}
}
