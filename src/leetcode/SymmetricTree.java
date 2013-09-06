package leetcode;

public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isMirrorTree(root.left, root.right);
	}

	public boolean isMirrorTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if ((p == null && q != null) || (p != null && q == null)) {
			return false;
		} else {
			return (p.val == q.val) && isMirrorTree(p.left, q.right)
					&& isMirrorTree(p.right, q.left);
		}
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
