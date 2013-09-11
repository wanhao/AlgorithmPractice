package leetcode;

public class DistinctSubsequences {

	public static void main(String[] args) {
		DistinctSubsequences t=new DistinctSubsequences();
		String S = "rabbbit", T = "rabbit";
		System.out.println(t.numDistinct(S,T));
	}

    public int numDistinct(String S, String T) {
    	if(T==null || T.length()==0) return 1;
    	if(S==null || S.length()==0) return 0;
    	
    	int[] num=new int[T.length()+1];
    	num[num.length-1]=1;
    	
    	for(int i=S.length()-1;i>=0;i--){
    		for(int j=0;j<T.length();j++){
    			if(S.charAt(i)==T.charAt(j)){
    				num[j]+=num[j+1];
    			}
    		}
    	}
    	
    	return num[0];
    }
}
