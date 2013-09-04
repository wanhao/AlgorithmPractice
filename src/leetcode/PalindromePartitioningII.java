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

		int[] mincut=new int[s.length()+1];
		for(int i=0;i<mincut.length;i++){			
			mincut[i]=i;
		}
		boolean[] ispalin=new boolean[s.length()];
		
		for(int i=1;i<=s.length();i++){
			for(int k=0;k<i;k++){
				ispalin[k]=false;
				if (s.charAt(k)==s.charAt(i-1) && (k+1>=i-1 || ispalin[k+1])) {
					ispalin[k]=true;
					mincut[i]=Math.min(mincut[i],mincut[k]+1);
				}
			}
		}
		
		return mincut[s.length()]-1;
	}
	
//	public int minCut(String s) {
//		if (s == null || s.isEmpty())
//			return 0;
//
//		int[] mincut=new int[s.length()+1];
//		for(int i=0;i<mincut.length;i++){			
//			mincut[i]=i;
//		}
//		
//		for(int i=1;i<=s.length();i++){
//			for(int k=0;k<i;k++){
//				int start = k;
//				int end = i-1;
//				while (start <= end && s.charAt(start) == s.charAt(end)) {
//					start++;
//					end--;
//				}
//	
//				if (start > end && mincut[k]+1<mincut[i]) {
//					mincut[i]=mincut[k]+1;
//				}
//			}
//		}
//		
//		return mincut[s.length()]-1;
//	}
//
//	private int minCut(String s, int startLocation) {
//		if (startLocation >= s.length()) {
//			return 0;
//		}
//
//		int min = Integer.MAX_VALUE;
//		for (int endLocation = s.length() - 1; endLocation >= startLocation; endLocation--) {
//			int start = startLocation;
//			int end = endLocation;
//			while (start <= end && s.charAt(start) == s.charAt(end)) {
//				start++;
//				end--;
//			}
//
//			if (start > end) {
//				int value = minCut(s, endLocation + 1);
//				if(endLocation<s.length()-1) value++;
//				
//				if (value< min) {
//					min = value;
//				}
//			}
//		}
//
//		return min;
//	}
}
