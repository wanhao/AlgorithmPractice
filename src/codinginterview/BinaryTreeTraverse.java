package codinginterview;

import java.util.Stack;

public class BinaryTreeTraverse {

	public static void main(String[] args) {
		TreeNode root=new TreeNode(10);
		root.left=new TreeNode(5);
		root.left.left=new TreeNode(2);
		root.left.right=new TreeNode(7);
		root.left.left.right=new TreeNode(3);
		
		root.right=new TreeNode(12);
		root.right.right=new TreeNode(14);
		root.right.right.left=new TreeNode(13);
		
		preOrderTraverse(root);
		System.out.println();
		preOrderTraverseNoRecursion1(root);
		System.out.println();
		preOrderTraverseNoRecursion2(root);
		System.out.println();	
		
		inOrderTraverse(root);
		System.out.println();
		inOrderTraverseNoRecursion(root);
		
		System.out.println();
		postOrderTraverse(root);
		System.out.println();
		postOrderTraverseNoRecursion(root);
	}
	
	private static void visit(TreeNode node){
		if(node!=null){
			System.out.print(node.data+"  ");
		}
	}
	
	public static void preOrderTraverse(TreeNode root){
		if(root!=null){
			visit(root);
			preOrderTraverse(root.left);
			preOrderTraverse(root.right);
		}
	}
	
	public static void preOrderTraverseNoRecursion1(TreeNode root){
		Stack<TreeNode> stack=new Stack<TreeNode>();
		
		while(root!=null || !stack.isEmpty()){
			if(root!=null){
				visit(root);
				stack.push(root);
				root=root.left;
			}else{
				root=stack.pop();
				root=root.right;
			}
		}
	}
	
	public static void preOrderTraverseNoRecursion2(TreeNode root){
		if(root==null) return;
		
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			root=stack.pop();
			
			visit(root);
			if(root.right!=null){
				stack.push(root.right);
			}
			
			if(root.left!=null){
				stack.push(root.left);
			}
		}
	}
	
	public static void inOrderTraverse(TreeNode root){
		if(root!=null){
			inOrderTraverse(root.left);
			visit(root);
			inOrderTraverse(root.right);
		}
	}
	
	public static void inOrderTraverseNoRecursion(TreeNode root){
		Stack<TreeNode> stack=new Stack<TreeNode>();
		
		while(root!=null || !stack.isEmpty()){
			if(root!=null){
				stack.push(root);
				root=root.left;
			}else{
				root=stack.pop();
				visit(root);
				root=root.right;
			}
		}
	}
	
	public static void postOrderTraverse(TreeNode root){
		if(root!=null){
			postOrderTraverse(root.left);
			postOrderTraverse(root.right);
			visit(root);
		}
	}
	
	public static void postOrderTraverseNoRecursion(TreeNode root){
		if(root==null) return;
		
		Stack<TreeNode> tmp=new Stack<TreeNode>();
		Stack<TreeNode> output=new Stack<TreeNode>();
		
		tmp.push(root);
		while(!tmp.isEmpty()){
			TreeNode node=tmp.pop();
			output.push(node);
			
			if(node.left!=null){
				tmp.push(node.left);
			}
			if(node.right!=null){
				tmp.push(node.right);
			}
		}
		
		while(!output.isEmpty()){
			visit(output.pop());
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
