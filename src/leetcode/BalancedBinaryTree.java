package leetcode;


public class BalancedBinaryTree {

	public static void main(String[] args) {
		BalancedBinaryTree t=new BalancedBinaryTree();
		
		TreeNode root=null;
		System.out.println(t.isBalanced(root)==true);
		
		root=new TreeNode(1);
		System.out.println(t.isBalanced(root)==true);
		
		root.left=new TreeNode(2);
		System.out.println(t.isBalanced(root)==true);
		
		root.left.left=new TreeNode(3);
		System.out.println(t.isBalanced(root)==false);
		
		root.right=new TreeNode(4);
		System.out.println(t.isBalanced(root)==true);
	}

	public boolean isBalanced(TreeNode root) {
		return isBalancedInternal(root).balanced;
	}
	
	
	private Result isBalancedInternal(TreeNode root){
		if(root==null) return new Result(0,true);
		
		Result left=isBalancedInternal(root.left);
		if(!left.balanced) return new Result(0, false);
		
		Result right=isBalancedInternal(root.right);
		if(!right.balanced) return new Result(0, false);
		
		if(right.height-left.height>1 || left.height-right.height>1)
			return new Result(0,false);
		
		return new Result(1+Math.max(left.height,right.height), true);
	}

	static class Result{
		private int height=0;
		private boolean balanced=false;
		
		public Result(int h, boolean b){
			this.height=h;
			this.balanced=b;
		}
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
