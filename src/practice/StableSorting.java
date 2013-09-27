package practice;

import java.util.Arrays;
/**
 * 一个未排序整数数组，有正负数，重新排列使负数排在正数前面，并且要求不改变原来的正负数之间相对顺序。
比如： input: 1,7,-5,9,-12,15 ，ans: -5,-12,1,7,9,15 。

http://blog.csdn.net/v_july_v/article/details/7329314
 * @author wanhao
 *
 */
public class StableSorting {

	public static void main(String[] args) {
		StableSorting s=new StableSorting();
		int[] data=new int[]{-1,1,3,-2,2};
		s.stableSort(data);
		System.out.println(Arrays.toString(data));
		
		data=new int[]{1,-1, 2, -2, 3, -3, 4, -4, 5};
		s.stableSort(data);
		System.out.println(Arrays.toString(data));	
	}
	
	public void stableSort(int[] data){
		stableSort(data,0,data.length-1);
	}
	
	private int stableSort(int[] data, int start, int end){
		if(start==end){
			return data[start]>0?start:start+1;
		}
		
		int count=0;
		for(int i=start;i<=end;i++){
			if(data[i]<0){count++;}
		}
		if(count==0) {
			return start;
		}
		if(count==end-start+1){
			return end+1;
		}
		int middle=(start+end)/2;
		
		int left=stableSort(data,start,middle);
		int right=stableSort(data,middle+1,end);
		
		if(left>middle){
			return right;
		}
		if(right<=middle+1){
			return left;
		}
		
		reverse(data, left, middle);
		reverse(data, middle+1, right-1);
		reverse(data, left, right-1);
		
		return left+right-middle-1;
	}

	private void reverse(int[] data, int i, int j){
		while(i<j){
			int tmp=data[i];
			data[i]=data[j];
			data[j]=tmp;
			i++;
			j--;
		}
	}
}
