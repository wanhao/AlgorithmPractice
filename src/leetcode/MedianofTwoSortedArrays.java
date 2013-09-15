package leetcode;

public class MedianofTwoSortedArrays {

	public static void main(String[] args) {
		MedianofTwoSortedArrays t=new MedianofTwoSortedArrays();
		int[] A=new int[]{1,3,5,6};
		int[] B=new int[]{1,2,4,6,7,8,9};
		System.out.println(t.findMedianSortedArrays(A,B));
		
		A=new int[]{1,3,5,6};
		B=new int[]{1,2,4,6,7,8};
		System.out.println(t.findMedianSortedArrays(A,B));
		
		A=new int[]{1,3};
		B=new int[]{1,2,4,6,7,8,9};
		System.out.println(t.findMedianSortedArrays(A,B));
		
		A=new int[]{1,2};
		B=new int[]{1,2};
		System.out.println(t.findMedianSortedArrays(A,B));
	}

	public double findMedianSortedArrays(int A[], int B[]) {
		if(A==null){
			A=new int[0];
		}
		if(B==null){
			B=new int[0];
		}
		
		int n=A.length+B.length;
		if((n&0x01)==0){
			return 1.0*(findKthInSortedArrays(A,B,n/2)+findKthInSortedArrays(A,B,n/2+1))/2;
		}else{
			return findKthInSortedArrays(A,B,n/2+1);
		}
	}
	
	private int findKthInSortedArrays(int[] A, int[] B, int k){
		int i=0,j=0;
		int nexti, nextj,half=-1;
		while(k>1 && i<A.length && j<B.length){
			half=k/2;
			nexti=(i+half)<A.length?(i+half):A.length-1;
			nextj=(j+half)<B.length?(j+half):B.length-1;
			if(A[nexti]<B[nextj]){
				k-=nexti+1-i;
				i=nexti+1;
			}else{
				k-=nextj+1-j;
				j=nextj+1;
			}
		}
		if(i>=A.length){
			if(k>0) return B[j+k-1];
			else return B[j];
		}else if(j>=B.length){
			if(k>0) return A[i+k-1];
			else return A[i];
		}else{
			return A[i]<B[j]?A[i]:B[j];
		}
		
	}
	
}
