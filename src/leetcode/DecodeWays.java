package leetcode;

public class DecodeWays {

	public static void main(String[] args) {

	}

	public int numDecodings(String s) {
		if(s==null || s.length()==0) return 0;
		
		int[] num=new int[s.length()+1];
		num[0]=1;
		
		for(int i=1;i<=s.length();i++){
			if(s.charAt(i-1)!='0'){
				num[i]+=num[i-1];
			}
			if(i>=2 && s.charAt(i-2)!='0'){
				int value=Integer.valueOf(s.substring(i-2,i));
				if(value>=1 && value<=26){
					num[i]+=num[i-2];
				}
			}
		}
		return num[s.length()];
	}
}
