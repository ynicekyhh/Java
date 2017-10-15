package chapter03.person;

public class PersonTest {

	public static void main(String[] args) {
		Person p = new Student( "둘리" );
		
		p.setName( "둘리" );
		
		//DownCasting
		//Explicity Casting
		Student s1 = (Student)p;
		s1.set();
		
		( ( Student ) p ).set();
		
		
		//UpCasting
		//Implicity Casting
		Person p2 = s1;
		p2.setName( "마이콜" );
	}

}
