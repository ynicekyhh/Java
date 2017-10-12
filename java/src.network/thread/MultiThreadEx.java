package thread;

public class MultiThreadEx {

	public static void main(String[] args) {
		Thread thread1 = new AlphabetThread();
		Thread thread2 = new Thread( new DigitThread() );	//DigitThread는 Runnable을 구현한 객체
		
		//익명 클래스 사용
		new Thread( new Runnable() {
			
			@Override
			public void run() {
				for( char c = 'A'; c <= 'Z'; c++ ) {
					System.out.println( c );
					try {
						Thread.sleep( 1000 );
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		thread1.start();
		thread2.start();
		
//		for( int i = 0; i <= 9; i++ ) {
//			
//			System.out.print( i );
//		}
//		for( char c = 'a'; c <= 'z'; c++ ) {
//			System.out.print( c );
//		}
	}

}
