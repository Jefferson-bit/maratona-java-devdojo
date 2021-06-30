package datas.test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

public class InstantTest01 {
	public static void main(String[] args) {
		Instant now = Instant.now();
		System.out.println(now);
		System.out.println(LocalDateTime.now());
		System.out.println(now.getEpochSecond());
		System.out.println(now.getNano()); //representa o nano segundo do segundo, no maximo 999.999.999 esse valor
		System.out.println(Instant.ofEpochSecond(3));
		System.out.println(Instant.ofEpochSecond(3, 1_000_000_000));
		System.out.println("---------------------------------");
		Instant iInicial = Instant.now();
		try {
		       Thread.sleep(1000);
		} catch (InterruptedException e) {
		       e.printStackTrace();
		}
		Instant iFinal = Instant.now();

		Duration duracao = Duration.between(iInicial, iFinal);

		System.out.println("Duração em nanos segundos: " + duracao.toNanos());
		System.out.println("Duração em minutos: " + duracao.toMinutes());
		System.out.println("Duração em horas: " + duracao.toHours());
		System.out.println("Duração em milisegundos: " + duracao.toMillis());
		System.out.println("Duração em dias: " + duracao.toDays());
	}
}
