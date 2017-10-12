package practice05.prob5;

public class MyStackException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public MyStackException() {
		System.out.println(this.getClass() + ": stack is empty");
	}
}
