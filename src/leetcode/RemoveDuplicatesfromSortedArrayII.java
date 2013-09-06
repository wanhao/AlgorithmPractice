package leetcode;


public class RemoveDuplicatesfromSortedArrayII {
	
	public static void main(String[] args){
		RemoveDuplicatesfromSortedArrayII t=new RemoveDuplicatesfromSortedArrayII();
		int[] A = new int[]{1,1,1,1,2,2,3};
		int len=t.removeDuplicates(A);
		
		for(int i=0;i<len;i++){
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}
	
	public int removeDuplicates(int[] A) {
		if(A==null) return 0;
		if(A.length<=2) return A.length;
		
		int offset=2;
		for(int i=2;i<A.length;i++){
			if(A[i]!=A[offset-1] || A[i]!=A[offset-2]){
				A[offset++]=A[i];
			}
		}
		return offset;

	}
}
