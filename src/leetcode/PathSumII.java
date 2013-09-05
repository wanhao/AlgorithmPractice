package leetcode;

import java.util.ArrayList;

public class PathSumII {

	public static void main(String[] args) {

	}

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
		if (root != null) {
			pathSum(resultList, new ArrayList<Integer>(), root, 0, sum);
		}

		return resultList;
	}

	private void pathSum(ArrayList<ArrayList<Integer>> resultList,
			ArrayList<Integer> currentPath, TreeNode root, int current, int sum) {
		currentPath.add(root.val);
		current += root.val;

		if (root.left == null && root.right == null) {
			if (current == sum) {
				ArrayList<Integer> tmpList = new ArrayList<Integer>();
				tmpList.addAll(currentPath);
				resultList.add(tmpList);
			}
		} else {
			if (root.left != null) {
				pathSum(resultList, currentPath, root.left, current, sum);
			}
			if (root.right != null) {
				pathSum(resultList, currentPath, root.right, current, sum);
			}
		}

		currentPath.remove(currentPath.size() - 1);
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
