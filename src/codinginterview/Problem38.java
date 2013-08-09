package codinginterview;

import java.io.IOException;

public class Problem38 {
	public static void main(String args[]) throws IOException {
		//1
		int[] data=new int[]{};
		int value=3;
		System.out.println("first:"+searchFirst(data,value)+", last:"+searchLast(data,value));
		
		//2
		data=new int[]{1,2,4,5,6,6,7,8};
		value=3;
		System.out.println("first:"+searchFirst(data,value)+", last:"+searchLast(data,value));
		
		//3
		data=new int[]{1,2,3,4,5,6,6,7,8};
		value=3;
		System.out.println("first:"+searchFirst(data,value)+", last:"+searchLast(data,value));
		
		//4
		data=new int[]{1,2,3,3,3,4,5,6,6,7,8};
		value=3;
		System.out.println("first:"+searchFirst(data,value)+", last:"+searchLast(data,value));
		
		//5
		data=new int[]{1,2,4,5,6,6,7,8};
		value=0;
		System.out.println("first:"+searchFirst(data,value)+", last:"+searchLast(data,value));
		
		//6
		data=new int[]{1,2,4,5,6,6,7,8};
		value=1;
		System.out.println("first:"+searchFirst(data,value)+", last:"+searchLast(data,value));
		
		//7
		data=new int[]{1,1,1,2,4,5,6,6,7,8};
		value=1;
		System.out.println("first:"+searchFirst(data,value)+", last:"+searchLast(data,value));
		
		//8
		data=new int[]{1,2,4,5,6,6,7,8};
		value=8;
		System.out.println("first:"+searchFirst(data,value)+", last:"+searchLast(data,value));
		
		//9
		data=new int[]{1,2,4,5,6,6,7,8,8};
		value=8;
		System.out.println("first:"+searchFirst(data,value)+", last:"+searchLast(data,value));
		
		//2
		data=new int[]{1,2,4,5,6,6,7,8};
		value=23;
		System.out.println("first:"+searchFirst(data,value)+", last:"+searchLast(data,value));
	}
	
	public static int searchFirst(int[] data, int value){
		if(data==null||data.length<=0){
			return -1;
		}
		int low=0;
		int high=data.length-1;
		int middle=-1;
		while(low<=high){
			middle=(low+high)>>1;
			if(data[middle]==value){
				if(middle==0 || data[middle-1]!=value){
					return middle;
				}else{
					high=middle-1;
				}
			}else if(data[middle]<value){
				low=middle+1;
			}else{
				high=middle-1;
			}
		}
		
		return -1;
	}
	
	public static int searchLast(int[] data, int value){
		if(data==null||data.length<=0){
			return -1;
		}
		int low=0;
		int high=data.length-1;
		int middle=-1;
		while(low<=high){
			middle=(low+high)>>1;
			if(data[middle]==value){
				if(middle==data.length-1 || data[middle+1]!=value){
					return middle;
				}else{
					low=middle+1;
				}
			}else if(data[middle]<value){
				low=middle+1;
			}else{
				high=middle-1;
			}
		}
		
		return -1;
	}
}
