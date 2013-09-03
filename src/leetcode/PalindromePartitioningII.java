package leetcode;

public class PalindromePartitioningII {

	public static void main(String[] args) {
		PalindromePartitioningII t = new PalindromePartitioningII();

		String s = "aab";
		System.out.println(t.minCut(s));

		s = "aba";
		System.out.println(t.minCut(s));

		s = "abba";
		System.out.println(t.minCut(s));
		
		s = "abcdeba";
		System.out.println(t.minCut(s));
		
		s = "aaba";
		System.out.println(t.minCut(s));
	}

	public int minCut(String s) {
		if (s == null || s.isEmpty())
			return 0;

		return minCut(s, 0);
	}

	private int minCut(String s, int startLocation) {
		if (startLocation >= s.length()) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		for (int endLocation = s.length() - 1; endLocation >= startLocation; endLocation--) {
			int start = startLocation;
			int end = endLocation;
			while (start <= end && s.charAt(start) == s.charAt(end)) {
				start++;
				end--;
			}

			if (start > end) {
				int value = minCut(s, endLocation + 1);
				if(endLocation<s.length()-1) value++;
				
				if (value< min) {
					min = value;
				}
			}
		}

		return min;
	}
}
