package codinginterview;

import java.io.IOException;

public class Problem28 {
	public static void main(String args[]) throws IOException {
		char[] s = { 'a' };
		printArrangement(s);
		System.out.println("-----------------------------");
		printCombination(s);
		System.out.println("-----------------------------");

		s = new char[] { 'a', 'b', 'c' };
		printArrangement(s);
		System.out.println("-----------------------------");
		printCombination(s);
		System.out.println("-----------------------------");
	}

	public static void printCombination(char[] s) {
		if (s == null || s.length <= 0)
			return;
		printCombination(s, new boolean[s.length], 0);
	}

	public static void printCombination(char[] s, boolean[] p, int start) {
		if (start >= s.length) {
			boolean print = false;
			for (int i = 0; i < s.length; i++) {
				if (p[i]) {
					System.out.print(s[i]);
					print = true;
				}
			}
			if (print) {
				System.out.println();
			}
			return;
		}

		p[start] = true;
		printCombination(s, p, start + 1);
		p[start] = false;
		printCombination(s, p, start + 1);
	}

	public static void printArrangement(char[] s) {
		if (s == null || s.length <= 0)
			return;
		printArrangement(s, 0);
	}

	public static void printArrangement(char[] s, int start) {
		if (start >= s.length) {
			System.out.println(s);
			return;
		}

		for (int i = start; i < s.length; i++) {
			char tmp = s[i];
			s[i] = s[start];
			s[start] = tmp;

			printArrangement(s, start + 1);

			tmp = s[i];
			s[i] = s[start];
			s[start] = tmp;

		}
	}
}
