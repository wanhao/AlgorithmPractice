package leetcode;

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {

	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxPathSum(TreeNode root) {
		return maxPathSumIntern(root)[1];
	}
	
	private int[] maxPathSumIntern(TreeNode root){
		if(root==null) return new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE};
		
		int[] left=maxPathSumIntern(root.left);
		int[] right=maxPathSumIntern(root.right);
		
		int tmpMax=Math.max(left[0],right[0]);
		
		int maxAsRoot=root.val;
		if(tmpMax>0){
			maxAsRoot+=tmpMax;
		}
				
		int maxPath=Math.max(left[1],right[1]);
		
		tmpMax=root.val;
		if(left[0]>0){
			tmpMax+=left[0];
		}
		if(right[0]>0){
			tmpMax+=right[0];
		}
		
		if(tmpMax>maxPath){
			maxPath=tmpMax;
		}
		
		return new int[]{maxAsRoot, maxPath};
	}
}
