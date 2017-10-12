package practice05.prob1;

public class Sort {
	
	public static void main(String[] arg) {
	
		int array[] = { 5, 9, 3, 8, 60, 20, 1 };
		int temp = 0;
		int count =  array.length;
		
		System.out.println( "Before sort." );
		
		for (int i = 0; i < count; i++) {
			System.out.print( array[ i ] + " " );
		}
		
		System.out.println();
		System.out.println("---------------");
		
		
		//
		// 정렬 알고리즘이 적용된 코드를 여기에 작성합니다.
		// 
		
		int init = 1;
		int cnt = 1;
		
		for(int i=0; i<count; i++) {
			for(int j = 0; j < count -init; j++) {
				if(array[j] < array[j+1]) {
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
				System.out.print(">>" + cnt++ + "번 :\t");
				for (int k = 0; k < count; k++) {
					System.out.print(array[k] + " ");
				}
				System.out.println();
			}
			init++;
		}	

		System.out.println("---------------");
		System.out.println( "\nAfter Sort." );
		
		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}
	}
}