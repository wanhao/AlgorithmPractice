package leetcode;

import java.util.Arrays;

public class MergeSortedArray {
	
	public static void main(String[] args) {
		MergeSortedArray t=new MergeSortedArray();
		
		int[] A=new int[10];
		A[0]=1;
		A[1]=4;
		A[2]=7;
		A[3]=9;
		
		int[] B=new int[]{2,3,4,5};
		
		t.merge(A,4,B,4);
		System.out.println(Arrays.toString(A));
		
	}

	public void merge(int A[], int m, int B[], int n) {
		if (m < 0) {
			m = 0;
		}
		if (n < 0) {
			n = 0;
		}
		if (A == null || A.length < m + n || B == null || B.length < n)
			return;

		int i = m - 1, j = n - 1, k = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (A[i] >= B[j]) {
				A[k--] = A[i--];
			} else {
				A[k--] = B[j--];
			}
		}

		if (j >= 0) {
			System.arraycopy(B, 0, A, 0, j + 1);
		}

	}
}
