package leetcode;

public class PathSum {

	public static void main(String[] args) {

	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		return hasPathSum(root, 0, sum);
	}

	private boolean hasPathSum(TreeNode root, int current, int sum) {
		current += root.val;

		if (root.left == null && root.right == null) {
			return current == sum ? true : false;
		}
		if (root.left != null && hasPathSum(root.left, current, sum)) {
			return true;
		}
		if (root.right != null && hasPathSum(root.right, current, sum)) {
			return true;
		}
		return false;
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
