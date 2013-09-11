package leetcode;

import java.util.ArrayList;

public class Triangle {

	public static void main(String[] args) {

	}

	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle == null || triangle.isEmpty())
			return 0;

		int[] min = new int[triangle.size() + 1];
		for (int i = triangle.size() - 1; i >= 0; i--) {
			ArrayList<Integer> levelList = triangle.get(i);
			for (int j = 0; j <= i; j++) {
				if (min[j + 1] < min[j]) {
					min[j] = min[j + 1];
				}
				min[j] += levelList.get(j);
			}
		}
		return min[0];
	}
}
