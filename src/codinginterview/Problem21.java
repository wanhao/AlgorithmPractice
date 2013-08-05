package codinginterview;

import java.io.IOException;
import java.util.Stack;

public class Problem21 {
	public static void main(String args[]) throws IOException {
		
	}

	static class StackWithMin<E extends Comparable<E>> {
		private Stack<E> state = new Stack<E>();
		private Stack<E> value = new Stack<E>();

		public void push(E e) {
			value.push(e);
			E min=null;
			if(!state.isEmpty()){
				min=state.peek();
			}
			
			if (e != null && (min==null || e.compareTo(min) < 0)) {
				min=e;
			}
			state.push(min);
		}				

		public E pop() {
			if (value.isEmpty()) {
				return null;
			} else {
				state.pop();
				return value.pop();
			}
		}

		public E min() {
			if(state.isEmpty()){
				return null;
			}else{
				return state.peek();
			}
		}
	}

	static class StackWithMinAdv<E extends Comparable<E>> {
		private Stack<E> state = new Stack<E>();
		private Stack<E> value = new Stack<E>();

		public void push(E e) {
			value.push(e);

			if (e != null
					&& (state.isEmpty() || e.compareTo(state.peek()) < 0)) {
				state.push(e);
			}
		}

		public E pop() {
			if (value.isEmpty()) {
				return null;
			} else {
				E e = value.pop();
				if (e != null && !state.isEmpty() && e == state.peek()) {
					state.pop();
				}
				return e;
			}
		}

		public E min() {
			if(state.isEmpty()){
				return null;
			}else{				
				return state.peek();
			}
		}
	}
}
