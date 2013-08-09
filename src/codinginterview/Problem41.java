package codinginterview;

import java.io.IOException;

public class Problem41 {
	public static void main(String args[]) throws IOException {
		printSequenceOfSum(15);
		printSequenceOfSum(9);
	}
	
	public static void printSequenceOfSum(int sum){
		if(sum<3) return;
		int low=1;
		int high=2;
		int curSum=3;
		
		while(low<high){
			if(curSum==sum){
				for(int i=low;i<=high;i++){
					System.out.print(i+" ");
				}
				System.out.println();
				curSum+=high+1-low;
				low++;
				high++;
			}else if(curSum<sum){
				curSum+=high+1;
				high++;
			}else{
				curSum-=low;
				low++;
			}
		}
	}
}
