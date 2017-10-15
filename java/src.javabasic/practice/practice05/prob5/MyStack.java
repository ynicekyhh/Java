package practice.practice05.prob5;

import java.lang.reflect.Array;

public class MyStack<E> {
	
	private E[] buffer = null;
	private int index;
	
	@SuppressWarnings("unchecked")
	public MyStack(int capacity) {
		if(capacity>0) {
//			buffer = new E[capacity];
//			Array.newInstance( objects.getClass(), capacity);	//비추
//			buffer = (E[])Array.newInstance(Object.class, capacity);
			buffer = (E[])new Object[ capacity ];
		}
	}
	
	@SuppressWarnings("unchecked")
	public void push(E e) {
		if(index < 0) {
			index = 0;
		}
		
		//buffer full
		if(index == buffer.length) {
//			String[] tempBuffer = new String[buffer.length * 2]; 
			E[] tempBuffer = (E[])Array.newInstance(Integer.class, buffer.length * 2);
			
			int i=0;
			for(E str : buffer) {
				tempBuffer[i++] = str;
			}
			buffer = tempBuffer;
		}
		
		buffer[index++] = e;
	}
	
	public E pop() throws MyStackException{
		
		if(index <= 0) {
			throw new MyStackException();
		}
		
		E e = buffer[--index];
		buffer[index] = null;
		return e;
	}
	
	public boolean isEmpty() {
//		if(index <= 0) {
//			return true;
//		}
//		return false;
		return index == -1;
	}
}
