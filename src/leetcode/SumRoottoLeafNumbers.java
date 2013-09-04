package leetcode;

public class SumRoottoLeafNumbers {

	public static void main(String[] args) {
		SumRoottoLeafNumbers t=new SumRoottoLeafNumbers();
		
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		
		System.out.println(t.sumNumbers(root));
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumNumbers(TreeNode root) {
		if(root==null) return 0;
		StringBuilder sb=new StringBuilder();
		return sumNumbers(root,sb);
	}

	private int sumNumbers(TreeNode root, StringBuilder sb){
		sb.append(Integer.toString(root.val).toCharArray()[0]);
		
		int sum=0;
		if(root.left==null && root.right==null){
			sum=Integer.valueOf(sb.toString()).intValue();
		}else{
			if(root.left!=null){
				sum+=sumNumbers(root.left,sb);
			}
			if(root.right!=null){
				sum+=sumNumbers(root.right,sb);
			}	
		}
		
		sb.deleteCharAt(sb.length()-1);
		return sum;
	}
	

}
