package chapter04.lang;

public class SBTest {

	public static void main(String[] args) {
		
		//생성
		StringBuffer sb = new StringBuffer( "This" );
		System.out.println(
				sb.length() + ":" + sb.capacity() );
		System.out.println( sb );
		
		//문자열 추가
		sb.append( " is pencil" );
		System.out.println( sb );
		
		//삽입
		sb.insert( 7, " my" );
		System.out.println( sb );
		
		//치환
		sb.replace( 8, 10, "your" );
		System.out.println( sb );
		
		//버퍼 크기 조정
		sb.setLength( 3 );
		System.out.println( sb );
		
		// 문자열 + 연산은 내부적으로 StringBuffer 객체로 변환
		// s1은 내부적으로 s2의 과정을 거침 -> 코드가 지저분하니 빅데이터같은 대용량 처리할 때를 제외하고는 s1처럼 사용
		String s1 = "Hello" + " World" + 10 + true;
		String s2 = new StringBuffer( "Hello" ).
				append( " World").
				append( 10 ).
				append( true ).toString();
		
		System.out.println( s1 );
		System.out.println( s2 );
	}

}
