package dp;

import java.util.Arrays;

/**
 * http://hawstein.com/posts/dp-knapsack.html#3900
 * 
 * @author wanhao
 *
 */
public class Knapsack {

	public static void main(String[] args) {
		int[] v = new int[] { 4, 3, 5, 2, 5 };
		int[] w = new int[] { 9, 6, 1, 4, 1 };
		int capacity = 10;
		System.out.println(maxWeight(v,w,capacity)==19);
		System.out.println(maxWeightSpaceEfficient(v,w,capacity)==19);

		v = new int[] { 4, 3, 4, 2 };
		w = new int[] { 20, 6, 20, 4 };
		capacity = 9;
		System.out.println(maxWeight(v,w,capacity)==40);
		System.out.println(maxWeightSpaceEfficient(v,w,capacity)==40);
		
		v = new int[] { 2, 2, 6, 5, 4 };
		w = new int[] { 6, 3, 5, 4, 6 };
		capacity = 10;
		System.out.println(maxWeight(v,w,capacity)==15);
		System.out.println(maxWeightSpaceEfficient(v,w,capacity)==15);
	}
	
	public static int maxWeight(int[] v, int[] w, int capacity){
		int[][] d=new int[v.length+1][capacity+1];
		for(int i=0;i<=v.length;i++){
			for(int j=0;j<=capacity;j++){
				if(i==0){
					d[i][j]=0;
				}else{
					d[i][j]=d[i-1][j];
					if(j>=v[i-1]){
						d[i][j]=Math.max(d[i][j],d[i-1][j-v[i-1]]+w[i-1]);
					}
				}
			}
		}
		
		boolean[] c=new boolean[v.length];
		int tmp=capacity;
		for(int i=v.length;i>0;i--){
			if(d[i][tmp]!=d[i-1][tmp]){
				c[i-1]=true;
				tmp-=v[i-1];
			}
		}
		System.out.println(Arrays.toString(c));
		
		return d[v.length][capacity];
	}
	
	public static int maxWeightSpaceEfficient(int[] v, int[] w, int capacity){
		int[] d=new int[capacity+1];
		for(int i=0;i<=v.length;i++){
			for(int j=capacity;j>=0;j--){
				if(i==0){
					d[j]=0;
				}else{
					if(j>=v[i-1]){
						d[j]=Math.max(d[j],d[j-v[i-1]]+w[i-1]);
					}
				}
			}
		}
		
		return d[capacity];
	}
}
