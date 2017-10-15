package practice.practice03.prob04;

public class StringUtil {
	public static String concatenate(String[] str) {
        //문자열을 결합하여 리턴 하는 메소드 구현
		String result = null;
		for(int i = 0; i < str.length; i++) {
			if(i==0) {
				result = str[i];
			}else {
				result += str[i];
			}
		}
		
		return result;
	}
}
