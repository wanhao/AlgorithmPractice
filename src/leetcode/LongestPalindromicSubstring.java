package leetcode;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {

	}

	public String longestPalindrome(String s) {
		if(s==null || s.length()<=0) return null;
		
		int maxLen=0, maxStart=-1,maxEnd=-1;
		
		boolean[][] isPalindrome=new boolean[s.length()][s.length()];
		for(int i=0;i<s.length();i++){
			for(int j=0;j<=i;j++){
				if(s.charAt(i)==s.charAt(j) &&(i-j<=2 || isPalindrome[j+1][i-1])){
					isPalindrome[j][i]=true;
					if(i-j+1>maxLen){
						maxLen=i-j+1;
						maxStart=j;
						maxEnd=i;
					}
				}
			}
		}
		
		return s.substring(maxStart,maxEnd+1);
	}
}
