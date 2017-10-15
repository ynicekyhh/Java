package chapter04.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader( new FileReader("./src/io/BufferedReaderTest.java") );
			
			int index = 0;
			String line = null;
			while( ( line = br.readLine() ) != null ) {
				System.out.println( ++index + ":" + line );
			}
			
		} catch( FileNotFoundException e) {
			System.out.println( "파일 없음:" + e );
		} catch( IOException e ) {
			System.out.println( "I/O 에러:" + e );
		} finally {
			try {
				if( br != null ) {
					br.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
