package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {

	}

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		
		if(root==null) return result;
		
		
		LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
		queue.addLast(root);
		ArrayList<Integer> list=new ArrayList<Integer>();
		int current=0, currentMax=1, nextMax=0;
		boolean reverse=true;
		
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
				if(reverse){
					ArrayList<Integer> tmpList=new ArrayList<Integer>();
					for(int i=list.size()-1;i>=0;i--){
						tmpList.add(list.get(i));
					}
					result.add(tmpList);
					reverse=false;
				}else{					
					result.add(list);
					reverse=true;
				}
				list=new ArrayList<Integer>();
				current=0;
				currentMax=nextMax;
				nextMax=0;
			}
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
