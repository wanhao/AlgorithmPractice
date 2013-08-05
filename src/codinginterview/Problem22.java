package codinginterview;

import java.io.IOException;
import java.util.Stack;

public class Problem22 {
	public static void main(String args[]) throws IOException {
		// 1
		int[] push = new int[] { 1, 2, 3, 4, 5 };
		int[] pop = new int[] { 4, 5, 3, 2, 1 };
		System.out.println(isPopOrder(push, pop) == true);
		// 2
		push = new int[] { 1, 2, 3, 4, 5 };
		pop = new int[] { 3, 5, 4, 2, 1 };
		System.out.println(isPopOrder(push, pop) == true);

		// 3
		push = new int[] { 1, 2, 3, 4, 5 };
		pop = new int[] { 4, 3, 5, 1, 2 };
		System.out.println(isPopOrder(push, pop) == false);

		// 4
		push = new int[] { 1, 2, 3, 4, 5 };
		pop = new int[] { 3, 5, 4, 1, 2 };
		System.out.println(isPopOrder(push, pop) == false);
		
		// 5
		push = new int[] { 1};
		pop = new int[] { 2};
		System.out.println(isPopOrder(push, pop) == false);
		
		// 6
		push = new int[] { 1 };
		pop = new int[] { 1 };
		System.out.println(isPopOrder(push, pop) == true);
		
		// 7
		push = null;
		pop = null;
		System.out.println(isPopOrder(push, pop) == false);
	}

	public static boolean isPopOrder(int[] pushOrder, int[] popOrder) {
		if (pushOrder == null || pushOrder.length == 0 || popOrder == null
				|| popOrder.length == 0 || pushOrder.length != popOrder.length) {
			return false;
		}

		int popIndex = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int num : pushOrder) {
			stack.push(num);

			while (!stack.isEmpty() && stack.peek() == popOrder[popIndex]) {
				stack.pop();
				popIndex++;
			}
		}

		return stack.isEmpty();
	}
}
