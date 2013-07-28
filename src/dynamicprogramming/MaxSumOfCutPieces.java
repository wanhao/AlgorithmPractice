package dynamicprogramming;

/**
 * Given a sequence of numbers(no 0), cut it into several pieces with length no more than 5,
 * get the maximum sum of all the pieces.
 * 
 * @author wanhao
 *
 */
public class MaxSumOfCutPieces {
	
	public static void main(String[] args){
		//0
		String s="12345";
		System.out.println(maxSum(s)+","+(maxSum(s)==12345));
		
		//1
		s="123456";
		System.out.println(maxSum(s)+","+(maxSum(s)==23457));
				
		//2
		s="1234567";
		System.out.println(maxSum(s)+","+(maxSum(s)==34579));
	}
	
	public static int maxSum(String s){
		if(s.length()<=5) return Integer.valueOf(s);
		
		int[] sum=new int[s.length()];
		
		
		for(int i=0;i<sum.length;i++){
			if(i<5){
				sum[i]=Integer.valueOf(s.substring(0,i+1));
			}else{				
				sum[i]=Integer.valueOf(s.substring(i-4,i+1));
				for(int j=1;j<=5;j++){
					sum[i]=Math.max(sum[i], sum[i-j]+Integer.valueOf(s.substring(i-j+1, i+1)));
				}
			}
		}
		
		return sum[s.length()-1];
	}
}
