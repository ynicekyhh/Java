package chapter04.lang;

public class LangClassTest {

	public static void main(String[] args) {
		Rect a = new Rect(2, 3);
	    Rect b = new Rect(3, 2);
	    Rect c = new Rect(3, 4);		

	    if(a.equals(b)) System.out.println( "사각형 a 와 사각형 b는 같습니다." );
	    if(a.equals(c)) System.out.println( "사각형 a 와 사각형 c는 같습니다." );
	    if(b.equals(c)) System.out.println( "사각형 b 와 사각형 c는 같습니다." );
	    
	    System.out.println(a.hashCode());
	    System.out.println(b.hashCode());
	}

}
