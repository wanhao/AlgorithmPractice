package practice;

public class Solution {
	
	public static void main(String[] args){
		Solution t=new Solution();
		System.out.println(t.maxScore(new int[]{1,2,1,2}, new int[]{1,2}));
		
		System.out.println(t.maxScore(new int[]{1,2,1,2,1}, new int[]{1,2,1}));
	}

	
	public int maxScore(int[] score, int[] step){
		int[] f=new int[score.length];
		f[0]=score[0];
		
		int[][] remain=new int[score.length][4];
		for(int tmp:step){
			remain[0][tmp-1]++;
		}
		
		for(int i=1;i<score.length;i++){
			int flag=-1;
			for(int j=1;j<=4;j++){
				if(i-j>=0 && remain[i-j][j-1]>0 && f[i-j]>f[i]){
					f[i]=f[i-j];
					flag=j;
				}
			}
			f[i]+=score[i];
			for(int k=0;k<4;k++){
				remain[i][k]=remain[i-flag][k];
			}
			remain[i][flag-1]--;
		}
		
		return f[score.length-1];
	}
}
