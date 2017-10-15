package chapter04.lang;

public class StringTest02 {

	public static void main(String[] args) {
		String str1 = "abc";	// str1은 생성된 String 클래스의 객체(Object)를 가리킴
		String str2 = "cde";	// str2은 생성된 String 클래스의 객체(Object)를 가리킴
		String str3 = str2;		// str3에 str2의 값 할당
		
		str2 = str3.toUpperCase();	//새로 배열을 만들어 리턴
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);

		String str4 = str2.concat("??");
		System.out.println(str2);
		System.out.println(str4);
		
//		String s = "!";
//		String str5 = s.concat(str2);	//이 경우 s가 NULL이면 에러발생
//		Method Chaining
		String str5 = "!".concat( str2 );	// 이 경우 str2가 NULL이면 false를 리턴할 뿐 에러가 발생하지 않아 좋은 코드

	}

}
