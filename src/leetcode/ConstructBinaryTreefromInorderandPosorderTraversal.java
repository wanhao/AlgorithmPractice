package leetcode;

public class ConstructBinaryTreefromInorderandPosorderTraversal {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int postLen = (postorder == null ? 0 : postorder.length);
		int inLen = (inorder == null ? 0 : inorder.length);
		if (postLen != inLen)
			throw new IllegalArgumentException();
		if (postLen == 0)
			return null;
		return buildTree(inorder, 0, inorder.length - 1, postorder, 0,
				postorder.length - 1);
	}

	private TreeNode buildTree(int[] inOrder, int inStart, int inEnd,
			int[] postOrder, int postStart, int postEnd) {
		if (postStart > postEnd) {
			return null;
		}
		int rootPos = -1;
		for (int i = inStart; i <= inEnd; i++) {
			if (inOrder[i] == postOrder[postEnd]) {
				rootPos = i;
				break;
			}
		}
		if (rootPos < 0)
			throw new IllegalArgumentException();
		TreeNode root = new TreeNode(postOrder[postEnd]);
		
		if (rootPos > inStart) {
			root.left = buildTree(inOrder, inStart, rootPos - 1, postOrder,
					postStart, postStart + rootPos - inStart-1);
		}
		if (rootPos < inEnd) {
			root.right = buildTree(inOrder, rootPos + 1, inEnd, postOrder,
					postEnd + rootPos - inEnd, postEnd-1);
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
