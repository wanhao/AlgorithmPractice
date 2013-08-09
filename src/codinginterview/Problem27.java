package codinginterview;

import java.io.IOException;

public class Problem27 {
	public static void main(String args[]) throws IOException {
		TreeNode head=null;
		printList(convert(head));
		
		head=new TreeNode(1);
		printList(convert(head));
		
		head=new TreeNode(10);
		head.left=new TreeNode(5);
		printList(convert(head));
		
		head=new TreeNode(10);
		head.right=new TreeNode(15);
		printList(convert(head));
		
		head=new TreeNode(10);
		head.left=new TreeNode(5);
		head.right=new TreeNode(15);
		printList(convert(head));
		
		head=new TreeNode(10);
		head.left=new TreeNode(5);
		head.left.left=new TreeNode(2);
		printList(convert(head));
		
		head=new TreeNode(10);
		head.left=new TreeNode(5);
		head.left.left=new TreeNode(3);
		head.left.right=new TreeNode(7);
		head.right=new TreeNode(17);
		head.right.left=new TreeNode(13);
		printList(convert(head));
	}

	public static void printList(TreeNode[] head){
		if(head==null)return;
		
		StringBuilder sb=new StringBuilder();
		TreeNode tmp=head[0];
		while(tmp!=null){
			sb.append(tmp.data+"->");
			tmp=tmp.right;
		}
		System.out.println(sb.toString());
		
		sb.delete(0,sb.length());
		
		tmp=head[1];
		while(tmp!=null){
			sb.append(tmp.data+"->");
			tmp=tmp.left;
		}
		System.out.println(sb.toString());
		
		
	}
	
	public static TreeNode[] convert(TreeNode root){
		if(root==null){
			return null;
		}
		
		TreeNode leftHead=null,leftTail=null;
		TreeNode rightHead=null,rightTail=null;
		
		if(root.left!=null){
			TreeNode[] tmp=convert(root.left);
			leftHead=tmp[0];
			leftTail=tmp[1];
			leftTail.right=root;
			root.left=leftTail;
		}else{
			leftHead=root;
			root.left=null;
		}
		
		if(root.right!=null){
			TreeNode[] tmp=convert(root.right);
			rightHead=tmp[0];
			rightTail=tmp[1];
			root.right=rightHead;
			rightHead.left=root;
		}else{
			rightTail=root;
			root.right=null;
		}
		
		return new TreeNode[]{leftHead,rightTail};
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
