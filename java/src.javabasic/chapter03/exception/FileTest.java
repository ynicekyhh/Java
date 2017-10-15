package chapter03.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream( "./hello.txt" );
			int data = fis.read();
			
		} catch (FileNotFoundException e) {
		
			//e.printStackTrace();
			System.out.println( "파일이 없습니다.:" + e );
		
		} catch( IOException e ) {
			System.out.println( "파일 일기 실패:" + e );
		} 
		/*	
		} catch( Exception e ) {
			// 모든 예와를 한 곳에서 처리하고 싶을 때 
		} 
		*/
		
		finally {
			try {
				if( fis != null ) {
				fis.close();
				}
			} catch( IOException e ) {
				e.printStackTrace();
			}
		}
	}

}
