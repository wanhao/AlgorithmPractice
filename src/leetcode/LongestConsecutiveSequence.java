package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		LongestConsecutiveSequence t=new LongestConsecutiveSequence();
		
		int[] num=new int[]{100, 4, 200, 1, 3, 2};
		System.out.println(t.longestConsecutive(num));
		

		num=new int[]{100, 4, 200, -1, 3, -2, 0};
		System.out.println(t.longestConsecutive(num));
		
		num=new int[]{2147483646,-2147483647,0,2,2147483644,-2147483645,2147483645};
		System.out.println(t.longestConsecutive(num));
	}
	
	public int longestConsecutive(int[] num) {
		if(num==null || num.length==0) return 0;
		
		Set<Integer> set=new HashSet<Integer>();
		for(int tmp:num){
			set.add(tmp);
		}
		
		int max=0;
		int tmp=0;
		for(int value:num){
			if(set.isEmpty()) break;
			tmp=getCount(set,value,false)+getCount(set,value+1,true);
			if(tmp>max){
				max=tmp;
			}
		}
		return max;
	}
	
	private int getCount(Set<Integer> set, int value, boolean ascending){
		int count=0;
		while(set.contains(value)){
			count++;
			set.remove(value);
			value=ascending?value+1:value-1;
		}
		return count;
	}
	

//	public int longestConsecutive(int[] num) {
//		if(num==null || num.length==0) return 0;
//		
//		int max=Integer.MIN_VALUE;
//		int min=Integer.MAX_VALUE;
//		for(int tmp:num){
//			if(tmp>max){
//				max=tmp;
//			}
//			if(tmp<min){
//				min=tmp;
//			}
//		}
//		
//		int[] count1=null;
//		int[] count2=null;
//		if(max>=0){			
//			count1=new int[((max+1)>>>5)+1];
//		}
//		if(min<0){
//			count2=new int[((-min+1)>>>5)+1];
//		}
//		
//		for(int tmp:num){
//			if(tmp>=0){				
//				set(count1,tmp);
//			}else{
//				set(count2,-tmp);
//			}
//		}
//		
//		int maxLen=0;
//		int currentLen=0;
//		boolean tmp=false;
//		for(int i=min;i<=max;i++){
//			if(i<0){
//				tmp=get(count2,-i);
//			}else{
//				tmp=get(count1,i);
//			}
//			
//			if(tmp){
//				currentLen++;
//				if(currentLen>maxLen){
//					maxLen=currentLen;
//				}
//			}else{
//				currentLen=0;
//			}
//		}
//		return maxLen;
//	}
//	
//	private void set(int[] data, int index){
//		data[index>>>5]|=1<<(index&0x1f);
//	}
//	
//	private boolean get(int[] data, int index){
//		return (data[index>>>5]&(1<<(index&0x1f)))==0?false:true;
//	}
}
