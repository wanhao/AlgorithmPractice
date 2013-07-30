package codinginterview;

import java.io.IOException;

public class Problem8 {
	public static void main(String args[]) throws IOException {
		int[] a=new int[]{1};
		System.out.println(findMin(a)==1);
		
		a=new int[]{1,2,3,4};
		System.out.println(findMin(a)==1);
		
		a=new int[]{2,3,4,1};
		System.out.println(findMin(a)==1);
		
		a=new int[]{3,4,1,2};
		System.out.println(findMin(a)==1);
		
		a=new int[]{4,1,2,3};
		System.out.println(findMin(a)==1);
		
		a=new int[]{1,0,1,1,1};
		System.out.println(findMin(a)==0);
		
		a=new int[]{2,0,1,1,1};
		System.out.println(findMin(a)==0);
		
	}

	public static int findMin(int[] a){
		if(a==null || a.length==0) throw new IllegalArgumentException();
		
		int min=a[0];
		int low=0,high=a.length-1;
		while(low<=high){
			int mid=(low+high)/2;
			if(a[mid]==min){
				for( int i=low;i<=high;i++){
					if(a[i]<min){
						min=a[i];
					}
				}
				break;
			}else if(a[mid]<min){
				min=a[mid];
				high=mid-1;
			}else{
				low=mid+1;
			}
		}
		return min;
	}

}
