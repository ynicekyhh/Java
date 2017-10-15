package chapter04.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// 현재 시간
		Date now = new Date();
		
		System.out.println( now );
		printDate1(now);
		printDate2(now);
		
		// 특정시간 세팅 (2000/08/04)
		Date d1 = new Date(100, 7, 4);
		printDate2( d1 );
		
		// 특정시간 세팅 (2000/08/04 14:30:30)
		Date d2 = new Date(100, 7, 4, 14, 30, 30);
		printDate2( d2 );
		
		// 1970년 1월1일 00:00:00 기준
		// miliseconds 값을 세팅 - 24일, 60분, 60초, 밀리세컨즈, 365일, 30년
		// 기본 계산을 하면 int의 범위를 벗어나 라운딩 되면서 -값이 되니까 L을 맨 앞에 붙이면 계속 long값으로 계산
		Date d3 = new Date( 24L * 60 * 60 * 1000 * 365 * 30 );
		printDate2( d3 );	//윤년때문에 값이 예상과 다름
	}
	
	private static void printDate1( Date date ) {
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy년 MM월 dd일 hh시 mm분 ss초" );
		
		System.out.println( sdf.format(date) );
	}
	
	private static void printDate2( Date date ) {
		//년도 (+1900)
		int year = date.getYear();
		
		//월(0~11)
		int month = date.getMonth();
		
		//일
		int day = date.getDate();
		
		//시
		int hour = date.getHours();
		
		//분
		int minutes = date.getMinutes();
		
		//초
		int seconds = date.getSeconds();
		
		System.out.println(
				(year+1900) + "년 " +
				(month + 1) + "월 " +
				day + "일 " +
				hour + ":" +
				minutes + ":" +
				seconds
				);
	}
}
