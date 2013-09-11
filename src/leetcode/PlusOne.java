package leetcode;

import java.util.Arrays;

public class PlusOne {
	public static void main(String[] args){
		PlusOne t=new PlusOne();
		int[] digits=new int[]{0};
		System.out.println(Arrays.toString(t.plusOne(digits)));
	}
	public int[] plusOne(int[] digits) {
		if(digits==null||digits.length==0){
			return new int[]{1};
		}
		
		int carry=1;
		for(int i=digits.length-1;i>=0;i--){
			digits[i]+=carry;
			if(digits[i]>=10){
				digits[i]=0;
				carry=1;
			}else{
				carry=0;
				break;
			}
		}
		
		if(carry!=0){
			int[] value=new int[digits.length+1];
			System.arraycopy(digits,0,value,1,digits.length);
			value[0]=carry;
			return value;
		}else{
			return digits;
		}
	}
}
