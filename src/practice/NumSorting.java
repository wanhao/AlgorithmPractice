package practice;

import java.util.Arrays;

public class NumSorting {

	public static void main(String[] args) {
		NumSorting t=new NumSorting();
		int[] num=new int[]{2,3,0,4,1,8,6,5,7};
		t.sortNum(num);
		System.out.println(Arrays.toString(num));
	}

	public void sortNum(int[] num){
		if(num==null || num.length<=1) return;
		
		int tmp;
		for(int i=0;i<num.length;i++){
			while(num[i]!=i){
				tmp=num[num[i]];
				num[num[i]]=num[i];
				num[i]=tmp;
			}
		}
	}
}
