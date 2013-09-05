package leetcode;

public class FlattenBinaryTreetoLinkedList {

	public static void main(String[] args) {
		FlattenBinaryTreetoLinkedList t=new FlattenBinaryTreetoLinkedList();
		
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.left.left=new TreeNode(3);
		root.left.right=new TreeNode(4);
		root.right=new TreeNode(5);
		root.right.right=new TreeNode(6);
		
		t.flatten(root);
		t.printList(root);
	}
	
	public void printList(TreeNode root){
		while(root!=null){
			System.out.print(root.val+"->");
			root=root.right;
		}
	}

	public void flatten(TreeNode root) {
		treeToList(root);
	}

	private TreeNode[] treeToList(TreeNode root) {
		if (root == null)
			return null;

		TreeNode[] left = treeToList(root.left);
		TreeNode[] right = treeToList(root.right);

		root.left = null;
		TreeNode last = root;
		if (left != null) {
			last.right = left[0];
			left[0].left = last;
			last = left[1];
		}

		if (right != null) {
			last.right = right[0];
			right[0].left = last;
			last = right[1];
		}
		last.right = null;

		return new TreeNode[] { root, last };
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
