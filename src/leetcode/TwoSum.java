package leetcode;

public class TwoSum {

	public static void main(String[] args) {

	}

	public int[] twoSum(int[] numbers, int target) {
		if(numbers==null || numbers.length<2)return new int[]{0,0};
		
		for(int i=0;i<numbers.length;i++){
			for(int j=i+1;j<numbers.length;j++){
				if(numbers[i]+numbers[j]==target){
					return new int[]{i+1,j+1};
				}
			}
		}
		
		return new int[]{0,0};
	}
}
