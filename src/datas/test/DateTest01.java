package datas.test;

import java.util.Date;

public class DateTest01 {
	
	public static void main(String[] args) {
		Date date = new Date(1616409917882L);// valor Long em millisegundos, desde janeiro de 1970
		System.out.println(date.getTime());
		date.setTime(date.getTime() + 3_600_666);// add 1h
		System.out.println(date);	
	}
}
