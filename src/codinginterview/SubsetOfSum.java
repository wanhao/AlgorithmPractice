package codinginterview;

public class SubsetOfSum {

	public static void main(String[] args) {
		int[] set = { 3, 34, 4, 12, 5, 2 };

		System.out.println(subsetOfSum(set, 9));
		System.out.println(subsetOfSum(set, 11));
		System.out.println(subsetOfSum(set, 13));

		System.out.println(subsetOfSumDP(set, 9));
		System.out.println(subsetOfSumDP(set, 11));
		System.out.println(subsetOfSumDP(set, 13));

		subsetOfLessThanOrEqualSum(set, 9);
		subsetOfLessThanOrEqualSum(set, 10);
		subsetOfLessThanOrEqualSum(set, 11);
		subsetOfLessThanOrEqualSum(set, 13);
		subsetOfLessThanOrEqualSum(set, 30);

		System.out.println(fixedSizeSubsetOfSum(set, 2, 9));
		System.out.println(fixedSizeSubsetOfSum(set, 3, 9));
		System.out.println(fixedSizeSubsetOfSum(set, 4, 9));
		System.out.println(fixedSizeSubsetOfSum(set, 2, 16));
		System.out.println(fixedSizeSubsetOfSum(set, 3, 16));
		System.out.println(fixedSizeSubsetOfSum(set, 3, 19));
	}

	public static boolean fixedSizeSubsetOfSum(int[] set, int m, int sum) {
		if (set == null || set.length < m || sum < 0)
			return false;
		
		boolean[][] f=new boolean[m+1][sum+1];
		f[0][0]=true;
		
		for(int i=0;i<set.length;i++){
			for(int j=Math.min(i+1,m);j>=1;j--){
				for(int k=1;k<=sum;k++){
					if(set[i]<=k && f[j-1][k-set[i]]){
						f[j][k]=true;
					}
				}
			}
		}
		
		return f[m][sum];
	}

	public static boolean subsetOfSum(int[] set, int sum) {
		if (sum < 0)
			return false;
		if (sum == 0)
			return true;
		if (set == null || set.length <= 0)
			return false;

		return subsetOfSum(set, set.length - 1, sum);
	}

	public static boolean subsetOfSum(int[] set, int n, int sum) {
		if (sum == 0) {
			return true;
		}

		if (n < 0) {
			return false;
		}

		if (sum >= set[n] && subsetOfSum(set, n - 1, sum - set[n])) {
			return true;
		}

		return subsetOfSum(set, n - 1, sum);
	}

	public static boolean subsetOfSumDP(int[] set, int sum) {
		if (sum < 0)
			return false;
		if (sum == 0)
			return true;
		if (set == null || set.length <= 0)
			return false;

		boolean[] f = new boolean[sum + 1];
		f[0] = true;
		for (int i = 1; i <= sum; i++) {
			f[i] = false;
		}

		for (int i = 1; i <= set.length; i++) {
			for (int j = sum; j >= 1; j--) {
				if (j >= set[i - 1] && f[j - set[i - 1]]) {
					f[j] = true;
				}
			}
		}
		return f[sum];

		// boolean[][] f=new boolean[set.length+1][sum+1];
		// for(int i=0;i<set.length+1;i++){
		// f[i][0]=true;
		// }
		// for(int i=1;i<sum+1;i++){
		// f[0][i]=false;
		// }
		//
		// for(int i=1;i<=set.length;i++){
		// for(int j=1;j<=sum;j++){
		// f[i][j]=f[i-1][j];
		// if(j>=set[i-1] && f[i-1][j-set[i-1]]){
		// f[i][j]=true;
		// }
		// }
		// }
		// return f[set.length][sum];
	}

	public static void subsetOfLessThanOrEqualSum(int[] set, int sum) {
		if (sum <= 0 || set == null || set.length <= 0)
			return;
		best = new boolean[set.length];
		min = Integer.MAX_VALUE;

		subsetOfLessThanOrEqualSum(set, new boolean[set.length],
				set.length - 1, sum);
		System.out.println("sum=" + (sum - min));
		for (int i = 0; i < best.length; i++) {
			if (best[i]) {
				System.out.print(set[i] + " ");
			}
		}
		System.out.println();
	}

	private static int min = Integer.MAX_VALUE;
	private static boolean[] best = null;

	public static boolean subsetOfLessThanOrEqualSum(int[] set,
			boolean[] current, int n, int sum) {
		if (sum < min) {
			min = sum;
			for (int i = 0; i < current.length; i++) {
				best[i] = current[i];
			}
			if (sum == 0)
				return true;
		}

		if (n < 0) {
			return false;
		}

		if (sum >= set[n]) {
			current[n] = true;
			if (subsetOfLessThanOrEqualSum(set, current, n - 1, sum - set[n])) {
				return true;
			}
		}
		current[n] = false;
		return subsetOfLessThanOrEqualSum(set, current, n - 1, sum);
	}
}
