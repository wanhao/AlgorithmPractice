package leetcode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int preLen = (preorder == null ? 0 : preorder.length);
		int inLen = (inorder == null ? 0 : inorder.length);
		if (preLen != inLen)
			throw new IllegalArgumentException();
		if (preLen == 0)
			return null;
		return buildTree(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1);
	}

	private TreeNode buildTree(int[] preOrder, int preStart, int preEnd,
			int[] inOrder, int inStart, int inEnd) {
		if (preStart > preEnd) {
			return null;
		}
		int rootPos = -1;
		for (int i = inStart; i <= inEnd; i++) {
			if (inOrder[i] == preOrder[preStart]) {
				rootPos = i;
				break;
			}
		}
		if (rootPos < 0)
			throw new IllegalArgumentException();
		TreeNode root = new TreeNode(preOrder[preStart]);
		if (rootPos > inStart) {
			root.left = buildTree(preOrder, preStart + 1, preStart + rootPos
					- inStart, inOrder, inStart, rootPos - 1);
		}
		if (rootPos < inEnd) {
			root.right = buildTree(preOrder, preEnd + 1 + rootPos - inEnd,
					preEnd, inOrder, rootPos + 1, inEnd);
		}
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
