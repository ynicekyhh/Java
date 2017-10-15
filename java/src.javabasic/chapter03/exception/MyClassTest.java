package chapter03.exception;

import java.io.IOException;

public class MyClassTest {

	public static void main(String[] args) {
		try {
			MyClass myClass = new MyClass();
			myClass.danger();
		} catch (MyException | IOException e) {
			System.out.println( e );
		}

	}

}
