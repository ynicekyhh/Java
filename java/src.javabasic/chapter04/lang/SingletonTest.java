package chapter04.lang;

public class SingletonTest {

	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();
		
		System.out.println( s1 == s2 );
		System.out.println( s2 == s3 );
	}

}
