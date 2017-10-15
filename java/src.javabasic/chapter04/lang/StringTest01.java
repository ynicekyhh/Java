package chapter04.lang;

public class StringTest01 {

	public static void main(String[] args) {
		
		// 문자 " escape
		String s = "I Say \"hello\"";
		
		// 문자 ' escape
		char c = '\'';
		
		// 문자 \ escape
		String path = "d:\\bigdata";
		System.out.println(path);
		
		// \t, \n,\r, \b ..
		// \r : carriage return
		// \n : newline (\n이 들어온 위치 그대로 한줄 아래)
		System.out.println( "" );
		System.out.print("\n");
		
		// + 연산이 가능하다 => 뒷단에서는 StringBuffer로 바뀜
		String s1 = "Hello" + "World";
		String s2 = "";
		s2 += "World";
		
		// 내부 문자(배)열 가져오기
		char[] cs = s2.toCharArray();
		System.out.println(cs);
	}

}
