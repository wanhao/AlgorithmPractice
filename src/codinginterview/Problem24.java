package codinginterview;

import java.io.IOException;

public class Problem24 {
	public static void main(String args[]) throws IOException {
		int[] data=new int[]{4, 8, 6, 12, 16, 14, 10};
		System.out.println(isBST(data)==true);
		
		data=new int[]{4, 6, 7, 5};
		System.out.println(isBST(data)==true);
		
		data=new int[]{1, 2, 3, 4, 5};
		System.out.println(isBST(data)==true);
		
		data=new int[]{5, 4, 3, 2, 1};
		System.out.println(isBST(data)==true);
		
		data=new int[]{5};
		System.out.println(isBST(data)==true);
		
		data=new int[]{7, 4, 6, 5};
		System.out.println(isBST(data)==false);
		
		data=new int[]{4, 6, 12, 8, 16, 14, 10};
		System.out.println(isBST(data)==false);
		
		data=null;
		System.out.println(isBST(data)==false);
		
	}

	public static boolean isBST(int[] data){
		if(data==null||data.length<=0)return false;
		return isBST(data,0,data.length-1);
	}
	
	private static boolean isBST(int[] data, int start, int end) {
		if (start >= end)
			return true;

		int i = start;
		while (i < end && data[i] < data[end]) {
			i++;
		}

		// check is bst
		for (int j = i; j < end; j++) {
			if (data[j] <= data[end])
				return false;
		}

		// check left
		if (i < end && !isBST(data, i, end - 1)) {
			return false;
		}

		// check right
		if (i > start && !isBST(data, start, i - 1)) {
			return false;
		}
		return true;
	}

}
