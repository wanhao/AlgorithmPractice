package leetcode;

public class ConvertSortedArraytoBinarySearchTree {

	public static void main(String[] args) {

	}

	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length <= 0)
			return null;

		return sortedArrayToBST(num, 0, num.length-1);
	}

	private TreeNode sortedArrayToBST(int[] num, int low, int high) {
		if (low > high)
			return null;

		int middle = low + ((high - low) >> 1);

		TreeNode root = new TreeNode(num[middle]);
		root.left = sortedArrayToBST(num, low, middle - 1);
		root.right = sortedArrayToBST(num, middle + 1, high);

		return root;
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
