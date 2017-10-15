package chapter04.lang;

public class StringTest03 {

	public static void main(String[] args) {
		String s = "abcAbcabcABC";
		
		//charAt
		char c = s.charAt( 2 );
		System.out.println( c );
		
		//indexOf
		System.out.println( s.indexOf( "Abc" ) );
		System.out.println( s.indexOf( "ab" ) );
		System.out.println( s.lastIndexOf( "ab" ) );
		System.out.println( s.indexOf( "XYZ" ) );
		
		//replace(치환)
		System.out.println( s.replace( "bc", "12" ) );
		System.out.println( s.replaceAll( "bc", "12" ) );
		
		//substring
		System.out.println( s.substring( 3 , 7 ) );
		
		//case
		System.out.println( s.toLowerCase() );
		System.out.println( s.toUpperCase() );
		
		//concat
		String str1 = " ab cd  ";
		String str2 = ",efg";
		
		System.out.println( str1.concat( str2 ) );
		
		//trim
		/*
		 * web환경에서 사용자가 공백을 입력했을 때 등에서 사용
		 * 특히 회원가입시에는 DB에 들어가니 꼭 해야함
		 */
		System.out.println( "---" + str1 + "---" );
		System.out.println( "---" + str1.trim() + "---" );
		
		//split
		String[] tokens = str1.split( "," );
		for( String token : tokens ) {
			System.out.println( token );
		}
		
		//split 예외 : 잘라지지 않을 때는 하나만 리턴
		tokens = "abcdefg".split( "," );
		for( String token : tokens ) {
			System.out.println( token );
		}
		
		//주의! : NULL아님, 원소가 아무것도 없을 뿐
		tokens = "".split( "," );
//		for( String token : tokens ) {
//			System.out.println( token );
//		}
		System.out.println( tokens.length );
		System.out.println( "---" + tokens[0] + "---" );
	}

}
