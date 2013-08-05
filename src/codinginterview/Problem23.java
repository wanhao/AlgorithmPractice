package codinginterview;

import java.io.IOException;
import java.util.LinkedList;

public class Problem23 {
	public static void main(String args[]) throws IOException {
		
	}


	public static void printFromTopToBottom(TreeNode root){
		if(root==null) return;
		
		LinkedList<TreeNode> list=new LinkedList<TreeNode>();
		list.add(root);
		TreeNode tmp=null;
		while(!list.isEmpty()){
			tmp=list.remove();
			System.out.print(tmp.data+" ");
			if(tmp.left!=null){
				list.add(tmp.left);
			}
			if(tmp.right!=null){
				list.add(tmp.right);
			}
		}
	}
	
	static class TreeNode{
		private int data;
		private TreeNode left,right;
		
		public TreeNode(int data){
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
}
