package leetcode;

public class RemoveDuplicatesfromSortedArray {

	public int removeDuplicates(int[] A) {
		if(A==null || A.length==0) return 0;
		
		int offset=1;
		for(int i=1;i<A.length;i++){
			if(A[i]!=A[offset-1]){
				A[offset++]=A[i];
			}
		}
		return offset;
	}
}
