package codinginterview;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem3{
	public static void main(String[] args) throws IOException{
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int m = (int) st.nval;
			st.nextToken();
			int n = (int) st.nval;
			st.nextToken();
			int value = (int) st.nval;
			int[] matrix = new int[m * n];
			for (int i = 0; i < m * n; i++) {
				st.nextToken();
				matrix[i] = (int) st.nval;
			}

			if (findNumber(matrix, m, n, value)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}

	}
	
	public static boolean findNumber(int[] matrix,int rows, int columns, int value) {
		if (matrix == null|| rows<=0 ||columns<=0){
			return false;
		}

		int i = 0, j = columns - 1;
		int tmp=-1;
		while (i < rows && j >= 0) {
			tmp=matrix[i*columns+j];
			if (tmp == value) {
				return true;
			} else if (tmp < value) {
				i++;
			} else {
				j--;
			}
		}
		
		return false;
	}
}