package leetcode;

import java.util.ArrayList;

public class UniqueBinarySearchTreesII {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {
		UniqueBinarySearchTreesII t=new UniqueBinarySearchTreesII();
		
		System.out.println(t.generateTrees(3).size());
	}
	
	public ArrayList<TreeNode> generateTrees(int n) {
		if (n <= 0){
			ArrayList<TreeNode> list=new ArrayList<TreeNode>();
			list.add(null);
			return list;
		}
		
		return generateTrees(1, n);
	}

	private ArrayList<TreeNode> generateTrees(int start, int end) {
		if (start > end)
			return null;

		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		for (int i = start; i <= end; i++) {
			ArrayList<TreeNode> leftList = generateTrees(start, i - 1);
			ArrayList<TreeNode> rightList = generateTrees(i + 1, end);
			if (leftList == null && rightList == null) {
				list.add(new TreeNode(i));
			} else if (leftList == null) {
				for (TreeNode tmpNode : rightList) {
					TreeNode root = new TreeNode(i);
					root.right = tmpNode;
					list.add(root);
				}
			} else if (rightList == null) {
				for (TreeNode tmpNode : leftList) {
					TreeNode root = new TreeNode(i);
					root.left = tmpNode;
					list.add(root);
				}
			} else {
				for (TreeNode tmpLeftNode : leftList) {
					for (TreeNode tmpRightNode : rightList) {
						TreeNode root = new TreeNode(i);
						root.left = tmpLeftNode;
						root.right = tmpRightNode;
						list.add(root);
					}
				}
			}
		}

		return list.isEmpty() ? null : list;
	}
}
