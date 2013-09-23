package practice;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		LongestIncreasingSubsequence t = new LongestIncreasingSubsequence();
		System.out.println(t.maxLength(new int[] { 2, 2, 1, 3, 4, 5, 3, 8, 9,
				10, 8, 9 }));

		System.out.println(t.maxSumofMaxLength(new int[] { 2, 2, 1, 3, 4, 5, 3,
				8, 9, 10, 8, 9 }));
		System.out.println(t.maxSumofMaxLength(new int[] { 2, 2, 1, 3, 4, 5, 3,
				8, 9, 8, 9 }));

	}

	public int maxSumofMaxLength(int[] array) {
		if (array == null || array.length <= 0)
			return 0;

		int maxLen = 1;
		int maxSum = array[0];

		int currentMaxLen = 1;
		int currentMaxSum = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[i - 1]) {
				currentMaxLen++;
				currentMaxSum += array[i];
				if (currentMaxLen > maxLen
						|| (currentMaxLen == maxLen && currentMaxSum > maxSum)) {
					maxLen = currentMaxLen;
					maxSum = currentMaxSum;
				}
			} else {
				currentMaxLen = 1;
				currentMaxSum = array[i];
			}
		}
		return maxSum;
	}

	public int maxLength(int[] array) {
		if (array == null || array.length <= 0)
			return 0;

		int max = 1;
		int currentMax = 1;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[i - 1]) {
				currentMax++;
				if (currentMax > max) {
					max = currentMax;
				}
			} else {
				currentMax = 1;
			}
		}
		return max;
	}

}
