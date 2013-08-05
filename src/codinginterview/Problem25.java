package codinginterview;

import java.io.IOException;
import java.util.LinkedList;

public class Problem25 {
	public static void main(String args[]) throws IOException {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(7);
		root.right = new TreeNode(12);

		printPath(root, 22);

		System.out.println("------------------------------------");
		printPath(root, 15);

		System.out.println("------------------------------------");
		root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(2);
		root.left.left.left.left = new TreeNode(1);
		printPath(root, 15);

		System.out.println("------------------------------------");
		root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(3);
		root.right.right.right = new TreeNode(4);
		root.right.right.right.right = new TreeNode(5);
		printPath(root, 16);

		System.out.println("------------------------------------");
		root = new TreeNode(1);
		printPath(root, 1);

		System.out.println("------------------------------------");
		root = null;
		printPath(root, 0);
	}

	public static void printPath(TreeNode root, int sum) {
		printPath(root, new LinkedList<TreeNode>(), 0, sum);
	}

	public static void printPath(TreeNode root, LinkedList<TreeNode> preList,
			int preSum, int sum) {
		if (root == null) {
			return;
		} else {
			preList.add(root);
			preSum += root.data;
			if (root.left == null && root.right == null) {
				if (preSum == sum) {
					if (!preList.isEmpty()) {
						StringBuilder sb = new StringBuilder();
						int i = 0;
						for (TreeNode node : preList) {
							sb.append(node.data);
							if (i++ != preList.size() - 1) {
								sb.append("->");
							}
						}
						System.out.println(sb.toString());
					}
				}
			}
			if (root.left != null) {
				printPath(root.left, preList, preSum, sum);
			}
			if (root.right != null) {
				printPath(root.right, preList, preSum, sum);
			}
			preList.removeLast();
		}

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
