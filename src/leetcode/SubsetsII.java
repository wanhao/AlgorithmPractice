package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsII {

	public static void main(String[] args) {
		SubsetsII t = new SubsetsII();
		int[] S = new int[] { 5, 5, 5, 5, 5 };
		System.out.println(t.subsetsWithDup(S));
	}

	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result.add(new ArrayList<Integer>());
		if (num != null && num.length > 0) {
			Arrays.sort(num);
			subsets(result, num, 0);
		}
		return result;
	}

	private void subsets(ArrayList<ArrayList<Integer>> result, int[] num,
			int pos) {
		if (pos >= num.length) {
			return;
		}
		int nextPos = pos + 1;
		if (pos < num.length - 1 && num[pos] == num[pos + 1]) {
			while (nextPos < num.length && num[nextPos] == num[pos]) {
				nextPos += 1;
			}
		}

		int dupNum = nextPos - pos;

		int size = result.size();
		for (int i = 0; i < size; i++) {
			ArrayList<Integer> last = result.get(i);
			for (int j = 1; j <= dupNum; j++) {
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				tmp.addAll(last);
				for (int k = 0; k < j; k++) {
					tmp.add(num[pos]);
				}
				result.add(tmp);
			}
		}
		subsets(result, num, nextPos);

	}
}
