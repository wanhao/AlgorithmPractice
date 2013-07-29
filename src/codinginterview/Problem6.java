package codinginterview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Problem6 {
	public static void main(String args[]) throws IOException {
		StreamTokenizer reader = new StreamTokenizer(new BufferedReader(new InputStreamReader(
				System.in)));
		while (reader.nextToken()!=StreamTokenizer.TT_EOF) {
			int n=(int)reader.nval;
			int[] preOrder=new int[n];
			int[] inOrder=new int[n];
		
			for(int i=0;i<n;i++){
				reader.nextToken();
				preOrder[i]=(int)reader.nval;
			}
			
			for(int i=0;i<n;i++){
				reader.nextToken();
				inOrder[i]=(int)reader.nval;
			}
			
			try{
				TreeNode root=constructBinaryTree(preOrder,inOrder);
				postOrderTraversal(root);
				System.out.println();
			}catch(Exception e){
				System.out.println("No");
			}
		}

	}
	
	private static void postOrderTraversal(TreeNode root){
		if(root!=null){
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.data+" ");
		}
	}

	public static TreeNode constructBinaryTree(int[] preOrder, int[] inOrder) {
		if (preOrder == null || inOrder == null
				|| preOrder.length != inOrder.length) {
			throw new IllegalArgumentException();
		}
		return constructBinaryTree(preOrder, 0, preOrder.length-1, inOrder, 0,
				inOrder.length-1);
	}

	private static TreeNode constructBinaryTree(int[] preOrder, int preStart,
			int preStop, int[] inOrder, int inStart, int inStop) {
		TreeNode root = new TreeNode(preOrder[preStart]);
		int rootPosition = -1;
		for (int i = inStart; i <= inStop; i++) {
			if (inOrder[i] == preOrder[preStart]) {
				rootPosition = i;
				break;
			}
		}

		if (rootPosition < 0)
			throw new IllegalArgumentException();
		if (rootPosition != inStart) {
			root.left = constructBinaryTree(preOrder, preStart + 1, preStart
					+ rootPosition - inStart, inOrder, inStart,
					rootPosition - 1);
		}
		if (rootPosition != inStop) {
			root.right = constructBinaryTree(preOrder, preStart + rootPosition
					- inStart + 1, preStop, inOrder, rootPosition + 1, inStop);
		}
		return root;
	}

	static class TreeNode {
		private int data;
		private TreeNode left, right;

		public TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
}
