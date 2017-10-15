package chapter04.io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BufferedOutputStreamTest {

	public static void main(String[] args) {
		BufferedOutputStream bos = null;
		OutputStream os = null;
		try {
			os = new FileOutputStream( "./1234.txt" );
//			bos = new BufferedOutputStream( new FileOutputStream( "./123.txt" ), 20 );
			bos = new BufferedOutputStream(os);
			
			// file에 입력할 때, ASKII값으로 변환되어 들어가기 때문에 '1'을 입력해야 하며, 자동으로 upcasting된다.
			for( int i = '1'; i <= '9'; i++ ) {
				bos.write( i );
				
				// 버퍼가 풀나지 않은 상태에서 플러시를 강제로 한다.
				// 버퍼가 풀 나면 자동 플러시
				// close() 호출하면 자동 플러시
				bos.flush();
			}
		} catch (FileNotFoundException e) {
			System.out.println( "파일 없음:" + e );
		} catch ( IOException e ) {
			System.out.println( "I/O 에러:" + e );
		} finally {
			try {
				if( bos != null) {
					bos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
