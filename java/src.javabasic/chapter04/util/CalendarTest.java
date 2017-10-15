package chapter04.util;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		printDate( cal );
		
		Calendar cal2 = Calendar.getInstance();
		cal2.set( Calendar.YEAR, 2007 );
		cal2.set( Calendar.MONTH, 10 );	//-1을 한 값으로 설정
		cal2.set( Calendar.DATE, 12 );
		//cal2.set( 2007, 10, 12 );
		
		cal2.add( Calendar.DATE, 100 );
		printDate( cal2 );
		
		cal2.set( 2007, 10, 12 );
		cal2.add( Calendar.DATE, 1000 );
		printDate( cal2 );

		cal2.set( 2007, 10, 12 );
		cal2.add( Calendar.DATE, 10000 );
		printDate( cal2 );
	}

	public static void printDate(Calendar cal) {
		String[] days = { "일", "월", "화", "수", "목", "금", "토" };
		int year = cal.get( Calendar.YEAR );
		// 0 ~ 11
		int month = cal.get( Calendar.MONTH );
		int date = cal.get( Calendar.DATE );
		//1(일) ~ 7(토)
		int day = cal.get( Calendar.DAY_OF_WEEK );
		
		int am = cal.getMaximum( Calendar.AM_PM );
		int hour = cal.get( Calendar.HOUR );
		int minute = cal.get( Calendar.MINUTE );
		int seconds = cal.get( Calendar.SECOND );
		
		System.out.println(
				year + "년 " +
				(month + 1) + "월 " +
				date + "일 " +
				"(" + days[day-1] + ")" +
				( am == 9 ? " 오전 " : " 오후 " ) +
				hour + ":" +
				minute + ":" +
				seconds
				);
	}

}
