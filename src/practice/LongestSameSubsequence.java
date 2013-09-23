package practice;

public class LongestSameSubsequence {

	
	public static void main(String[] args) {
		LongestSameSubsequence t=new LongestSameSubsequence();
		
		System.out.println(t.longestSubStr("000110101111"));
	}

	public String longestSubStr(String s){
		if(s==null || s.isEmpty()) return null;
		
		int maxStart=0, maxEnd=1;
		int curStart=0;
		for(int i=1;i<=s.length();i++){
			if(i>=s.length() ||s.charAt(i)!=s.charAt(curStart)){
				if(i-curStart>maxEnd-maxStart){
					maxStart=curStart;
					maxEnd=i;
				}
				curStart=i;
			}
		}
		return s.substring(maxStart,maxEnd);
	}
}
