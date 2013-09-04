package leetcode;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		LongestConsecutiveSequence t=new LongestConsecutiveSequence();
		
		int[] num=new int[]{100, 4, 200, 1, 3, 2};
		System.out.println(t.longestConsecutive(num));
		

		num=new int[]{100, 4, 200, -1, 3, -2, 0};
		System.out.println(t.longestConsecutive(num));
	}

	public int longestConsecutive(int[] num) {
		if(num==null || num.length==0) return 0;
		
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		for(int tmp:num){
			if(tmp>max){
				max=tmp;
			}
			if(tmp<min){
				min=tmp;
			}
		}
		
		int[] count1=null;
		int[] count2=null;
		if(max>=0){			
			count1=new int[max+1];
		}
		if(min<0){
			count2=new int[-min+1];
		}
		
		for(int tmp:num){
			if(tmp>=0){				
				count1[tmp]++;
			}else{
				count2[-tmp]++;
			}
		}
		
		int maxLen=0;
		int currentLen=0;
		int tmp=0;
		for(int i=min;i<=max;i++){
			if(i<0){
				tmp=count2[-i];
			}else{
				tmp=count1[i];
			}
			
			if(tmp>0){
				currentLen++;
				if(currentLen>maxLen){
					maxLen=currentLen;
				}
			}else{
				currentLen=0;
			}
		}
		return maxLen;
	}
}
