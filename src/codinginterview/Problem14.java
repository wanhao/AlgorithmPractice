package codinginterview;

import java.io.IOException;
import java.util.Arrays;

public class Problem14 {
	public static void main(String args[]) throws IOException {
		int[] a=new int[]{1};
		partition(a);
		System.out.println(Arrays.toString(a));
		
		a=new int[]{1,2};
		partition(a);
		System.out.println(Arrays.toString(a));
		
		a=new int[]{2,1};
		partition(a);
		System.out.println(Arrays.toString(a));
		
		a=new int[]{2,4,6,1,3};
		partition(a);
		System.out.println(Arrays.toString(a));
		
		a=new int[]{1,2,5,6,3,6,8};
		partition(a);
		System.out.println(Arrays.toString(a));
		
	}

	public static void partition(int[] a){
		if(a==null||a.length<=1)return;
		int i=-1,j=a.length;
		for(;;){
			while(++i<j &&(a[i]&0x01)!=0);
			while(--j>i && (a[j]&0x01)==0);
			if(i>=j)break;
			int tmp=a[i];
			a[i]=a[j];
			a[j]=tmp;
		}
	}
}
