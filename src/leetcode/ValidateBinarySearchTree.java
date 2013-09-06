package leetcode;

public class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
		return isValidBST(root,new int[2]);
	}

	private boolean isValidBST(TreeNode root, int[] minmax) {
		if (root == null) {
			minmax[0] = Integer.MAX_VALUE;
			minmax[1] = Integer.MIN_VALUE;
			return true;
		}
		
		if (!isValidBST(root.left, minmax) || minmax[1] >= root.val) {
			return false;
		}
		int min=Math.min(minmax[0],root.val);
		
		if (!isValidBST(root.right, minmax) || minmax[0] <= root.val) {
			return false;
		}
		int max=Math.max(minmax[1],root.val);
		
		minmax[0]=min;
		minmax[1]=max;
		return true;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
