package leetcode;

public class MinimumDepthofBinaryTree {

	public static void main(String[] args) {
		MinimumDepthofBinaryTree t=new MinimumDepthofBinaryTree();
		
		TreeNode root=null;
		System.out.println(t.minDepth(root)==0);
		
		root=new TreeNode(1);
		System.out.println(t.minDepth(root)==1);
		
		root.left=new TreeNode(2);
		root.left.left=new TreeNode(3);
		System.out.println(t.minDepth(root)==3);
		
		root.right=new TreeNode(4);
		System.out.println(t.minDepth(root)==2);
	}

	public int minDepth(TreeNode root) {
		if(root==null) return 0;
		
		if(root.left==null && root.right==null) return 1;
		
		int min=Integer.MAX_VALUE;
		if(root.left!=null){
			min=minDepth(root.left);
		}
		if(root.right!=null){			
			int right=minDepth(root.right);
			if(right<min){
				min=right;
			}
		}
		
		return min+1;
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
