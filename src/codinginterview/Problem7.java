package codinginterview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Stack;

public class Problem7 {
	public static void main(String args[]) throws IOException {
		StreamTokenizer reader = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));

		MyQueue<Integer> queue = new MyQueue<Integer>();

		while (reader.nextToken() != StreamTokenizer.TT_EOF) {
			int n = (int) reader.nval;

			String cmd = null;
			for (int i = 0; i < n; i++) {
				reader.nextToken();
				cmd = reader.sval;

				if (cmd.equals("PUSH")) {
					reader.nextToken();
					queue.appendTail((int) reader.nval);
				} else if (cmd.equals("POP")) {
					Integer head = queue.removeHead();
					if (head == null) {
						System.out.println(-1);
					} else {
						System.out.println(head.intValue());
					}
				}
			}

		}

	}

	static class MyQueue<E> {
		private Stack<E> stack1 = new Stack<E>();
		private Stack<E> stack2 = new Stack<E>();

		public void appendTail(E e) {
			stack1.push(e);
		}

		public E removeHead() {
			if (stack2.isEmpty() && !stack1.isEmpty()) {
				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
			}

			if (stack2.isEmpty()) {
				return null;
			} else {
				return stack2.pop();
			}
		}
	}

}
