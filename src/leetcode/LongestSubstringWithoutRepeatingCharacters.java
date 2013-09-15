package leetcode;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {


	}
	
	public int lengthOfLongestSubstring(String s) {
		if(s==null || s.length()<=0) return 0;
        
		boolean[] exist=new boolean[128];
		int max=1;
		int j=1;
		for(int i=0;i<s.length();i++){
			exist[s.charAt(i)&0xff]=true;
			if(j<i+1){j=i+1;}
			while(j<s.length() && !exist[s.charAt(j) & 0xff]){
				exist[s.charAt(j) & 0xff]=true;
				if(j-i+1>max){
					max=j-i+1;
				}
				j++;
			}
			if(j>=s.length()) break;
			exist[s.charAt(i)&0xff]=false;
		}
		
		return max;
    }
}