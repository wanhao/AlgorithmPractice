package leetcode;

import java.util.LinkedList;


public class InterleavingString {
	public static void main(String[] args) {
		InterleavingString t = new InterleavingString();
		System.out.println(t.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(t.isInterleave("aabcc", "dbbca", "aadbbbaccc"));

		long start = System.currentTimeMillis();

		String s1 = "accbaabaaabbcbaacbababacaababbcbabaababcaabbbbbcacbaa";
		String s2 = "cabaabcbabcbaaaacababccbbccaaabaacbbaaabccacabaaccbbcbcb";
		String s3 = "accbcaaabbaabaaabbcbcbabacbacbababaacaaaaacbabaabbcbccbbabbccaaaaabaabcabbcaabaaabbcbcbbbcacabaaacccbbcbbaacb";
		System.out.println(t.isInterleave(s1, s2, s3));

		long stop = System.currentTimeMillis();
		System.out.println(stop - start);
	}
	
	public boolean isInterleave(String s1, String s2, String s3) {
		int n1=(s1==null?0:s1.length());
    	int n2=(s2==null?0:s2.length());
		int n3=(s3==null?0:s3.length());
		
		if(n1+n2!=n3) return false;
		
		if(s1==null){
			if(((s2==null || s2.length()==0) && (s3==null||s3.length()==0))||(s2.equals(s3))){
				return true;
			}else{
				return false;
			}
		}
		if(s2==null){
			if(((s1==null || s1.length()==0) && (s3==null||s3.length()==0))||(s1.equals(s3))){
				return true;
			}else{
				return false;
			}
		}
		
		boolean[] match=new boolean[n2+1];
		match[n2]=true;
		for(int i=n2-1;i>=0;i--){
			match[i]=match[i+1] && s2.charAt(i)==s3.charAt(n1+i);
		}
		
		for(int i=n1-1;i>=0;i--){
			match[n2]=match[n2] && s1.charAt(i)==s3.charAt(n2+i);
			for(int j=n2-1;j>=0;j--){
				if(s1.charAt(i)==s3.charAt(i+j) && match[j]){
					match[j]=true;
					continue;
				}
				if(s2.charAt(j)==s3.charAt(i+j) && match[j+1]){
					match[j]=true;
					continue;
				}
				match[j]=false;
			}
		}
		return match[0];
	}
	
	

	public boolean isInterleave2(String s1, String s2, String s3) {
		int len1=(s1==null?0:s1.length());
    	int len2=(s2==null?0:s2.length());
		int len3=(s3==null?0:s3.length());
		
		if(len1+len2!=len3) return false;
		
		if(s1==null){
			if(((s2==null || s2.length()==0) && (s3==null||s3.length()==0))||(s2.equals(s3))){
				return true;
			}else{
				return false;
			}
		}
		if(s2==null){
			if(((s1==null || s1.length()==0) && (s3==null||s3.length()==0))||(s1.equals(s3))){
				return true;
			}else{
				return false;
			}
		}
		
		LinkedList<int[]> queue=new LinkedList<int[]>();
		queue.add(new int[]{0,0,0});
		
		while(!queue.isEmpty()){
			int[] index=queue.remove();
			
			boolean match0=false;
			boolean match1=false;
			while(index[2]<s3.length()){
				match0= index[0]<s1.length() && s1.charAt(index[0])==s3.charAt(index[2]);
				match1= index[1]<s2.length() && s2.charAt(index[1])==s3.charAt(index[2]);
				
				if(match0 && match1){
					queue.add(new int[]{index[0],index[1]+1,index[2]+1});
					queue.add(new int[]{index[0]+1,index[1],index[2]+1});
					break;
				}else if(match0){
					index[0]++;
					index[2]++;
				}else if(match1){
					index[1]++;
					index[2]++;
				}else{
					break;
				}
			}
			if(index[2]>=s3.length()){
				return true;
			}
		}
		
		return false;
	}

	private boolean isInterleave(String s1, int i, String s2, int j, String s3,
			int k) {
		if (k >= s3.length())
			return true;

		if (i < s1.length() && s1.charAt(i) == s3.charAt(k)
				&& isInterleave(s1, i + 1, s2, j, s3, k + 1)) {
			return true;
		}

		if (j < s2.length() && s2.charAt(j) == s3.charAt(k)
				&& isInterleave(s1, i, s2, j + 1, s3, k + 1)) {
			return true;
		}

		return false;
	}

}
