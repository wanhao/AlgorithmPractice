package leetcode;

public class SearchInsertPosition {

	public static void main(String[] args) {
		SearchInsertPosition t=new SearchInsertPosition();
		int[] A=new int[]{1,3,5,6};
		System.out.println(t.searchInsert(A,5)==2);
		System.out.println(t.searchInsert(A,2)==1);
		System.out.println(t.searchInsert(A,7)==4);
		System.out.println(t.searchInsert(A,0)==0);
	}

	public int searchInsert(int[] A, int target) {
		if(A==null || A.length<=0) return -1;
		
		int low=0, high=A.length-1,middle;
		
		while(low<=high){
			middle=low+((high-low)>>>1);
			if(A[middle]==target){
				return middle;
			}else if(A[middle]<target){
				low=middle+1;
			}else{
				high=middle-1;
			}
		}
		
		return low;
    }
}
