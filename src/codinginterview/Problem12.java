package codinginterview;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem12 {
	public static void main(String args[]) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int n = (int) st.nval;
			print(n);
		}
	}

	public static void print(int n) {
		if (n <= 0)
			return;
		int[] number = new int[n];
		print(number, 0);
	}

	private static void print(int[] number, int index) {
		if (index == number.length) {
			printOne(number);
			return;
		}

		for (int i = 0; i < 10; i++) {
			number[index] = i;
			print(number, index + 1);
		}
	}

	private static void printOne(int[] number) {
		boolean isZero = true;
		for (int tmp : number) {
			if (isZero && tmp != 0) {
				isZero = false;
			}
			if (!isZero) {
				System.out.print(tmp);
			}
		}
		if(!isZero){
			System.out.println();
		}
	}
}
