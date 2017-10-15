package chapter04.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

public class InputStreamReaderTest {

	public static void main(String[] args) {
		Reader reader = null;
		try {
			reader = new InputStreamReader( new FileInputStream( "./ms949.txt" ), "ms949" );
			
			int data = -1;
			while( (data = reader.read() ) != -1 ) {
				System.out.print( (char)data );
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println( "지원하지 않는 charset:" + e );
		} catch (FileNotFoundException e) {
			System.out.println( "파일없음:" + e );
		} catch ( IOException e ) {
			System.out.println( "I/O에러:" + e );
		} finally {
			try {
				if( reader != null ) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
