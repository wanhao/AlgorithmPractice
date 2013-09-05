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

	private TreeNode treeToList(TreeNode root) {
		if (root == null)
			return null;

		TreeNode left=root.left;
		TreeNode right=root.right;
		
		TreeNode leftEnd = treeToList(left);
		TreeNode rightEnd = treeToList(right);

		root.left = null;
		if (left != null) {
			root.right = left;
			root = leftEnd;
		}

		if (right != null) {
			root.right = right;
			root = rightEnd;
		}
		root.right = null;

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
