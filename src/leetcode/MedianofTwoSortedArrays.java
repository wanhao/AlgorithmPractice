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
		int half=-1;
		while(k>1 && i<A.length && j<B.length){
			half=k/2;
			if((i+half)<A.length &&(j+half)<B.length){
				if(A[i+half]<B[j+half]){
					k-=half;
					i+=half;
				}else if(A[i+half]>B[j+half]){
					k-=half;
					j+=half;
				}else{
					k-=half*2;
					i+=half;
					j+=half;
				}
			}else if(i+half<A.length){
				if(A[i+half]<B[B.length-1]){
					k-=half;
					i+=half;
				}else if(A[i+half]>B[B.length-1]){
					k-=B.length-j;
					j+=B.length-j;
				}else{
					k-=half+B.length-j;
					i+=half;
					j+=B.length-j;
				}
			}else if(j+half<B.length){
				if(A[A.length-1]<B[j+half]){
					k-=A.length-i;
					i+=A.length-i;
				}else if(A[A.length-1]>B[j+half]){
					k-=half;
					j+=half;
				}else{
					k-=half+A.length-i;
					i+=A.length-i;
					j+=half;
				}
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
