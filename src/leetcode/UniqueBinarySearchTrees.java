package leetcode;

public class UniqueBinarySearchTrees {

	public static void main(String[] args) {
		UniqueBinarySearchTrees t=new UniqueBinarySearchTrees();
		
		System.out.println(t.numTrees(3));
	}

	public int numTrees(int n) {
		if(n<=0) return 0;
		return numTrees(1,n);
	}
	
	private int numTrees(int start, int end){
		if(start>=end) return 1;
		
		int num=0;
		for(int i=start;i<=end;i++){
			int leftNum=numTrees(start,i-1);
			int rightNum=numTrees(i+1,end);
			
			num+=leftNum*rightNum;
		}
		
		return num;
	}
}
