package dp;

public class MaxSumOfSubsequence {

	public static void main(String[] args) {
		int[] a = new int[] { 5, 6, -1, 5, 4, -7 };
		System.out.println(maxSum(a) == 19);
		System.out.println(maxSumSimple(a) == 19);

		a = new int[] { 7, 0, 6, -1, 1, -6, 7, -5 };
		System.out.println(maxSum(a) == 14);
		System.out.println(maxSumSimple(a) == 14);
	}

	public static int maxSum(int[] a) {
		int[] value = new int[a.length];

		value[0] = a[0];
		int max = a[0];

		for (int i = 1; i < a.length; i++) {
			value[i] = a[i];
			if (value[i - 1] + a[i] > value[i]) {
				value[i] = value[i - 1] + a[i];
			}

			if (value[i] > max) {
				max = value[i];
			}
		}
		return max;
	}

	public static int maxSumSimple(int[] a) {
		int max = a[0];
		int preMax = a[0];

		for (int i = 1; i < a.length; i++) {
			if (preMax > 0) {
				preMax += a[i];
			} else {
				preMax = a[i];
			}

			if (preMax > max) {
				max = preMax;
			}
		}
		return max;
	}
}
