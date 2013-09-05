package leetcode;

public class MaximumDepthofBinaryTree {

	public static void main(String[] args) {

	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int leftMax = maxDepth(root.left);
		int rightMax = maxDepth(root.right);

		return Math.max(leftMax, rightMax) + 1;
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
