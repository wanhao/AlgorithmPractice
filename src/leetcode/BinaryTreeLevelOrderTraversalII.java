package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversalII {

	public static void main(String[] args) {

	}

	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		
		if(root==null) return result;
		
		Stack<ArrayList<Integer>> resultStack=new Stack<ArrayList<Integer>>();
		
		LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
		queue.addLast(root);
		ArrayList<Integer> list=new ArrayList<Integer>();
		int current=0, currentMax=1, nextMax=0;
		
		while(!queue.isEmpty()){
			TreeNode tmp=queue.removeFirst();
			list.add(tmp.val);
			current++;
			
			if(tmp.left!=null){
				queue.addLast(tmp.left);
				nextMax++;
			}
			if(tmp.right!=null){
				queue.addLast(tmp.right);
				nextMax++;
			}
			
			if(current==currentMax){
				resultStack.add(list);
				list=new ArrayList<Integer>();
				current=0;
				currentMax=nextMax;
				nextMax=0;
			}
		}
		
		while(!resultStack.isEmpty()){
			result.add(resultStack.pop());
		}
		
		return result;
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
