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
			return 1.0*(findKthInSortedArrays(A,0,B,0,n/2)+findKthInSortedArrays(A,0,B,0,n/2+1))/2;
		}else{
			return findKthInSortedArrays(A,0,B,0,n/2+1);
		}
	}
	
	private int findKthInSortedArrays(int[] A, int i, int[] B, int j,int k){
		if(A.length-i>B.length-j){
			return findKthInSortedArrays(B,j,A,i,k);
		}
		if(i>=A.length){
			return B[j+k-1];
		}
		if(k==1){
			return Math.min(A[i],B[j]);
		}
		
		int ii=Math.min(i+k/2-1,A.length-1);
		int jj=j+k-(ii-i+1)-1;
		
		if(A[ii]<B[jj]){
			return findKthInSortedArrays(A,ii+1,B,j,k-(ii-i+1));
		}else if(A[ii]>B[jj]){
			return findKthInSortedArrays(A,i,B,jj+1,ii-i+1);
		}else{
			return A[ii];
		}
	}
	
}
