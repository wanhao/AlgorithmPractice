package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		
	}
	
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(root==null) return result;
        
        Stack<TreeNode> stack=new Stack<TreeNode>();

        while(root!=null||!stack.isEmpty()){
        	if(root!=null){
        		stack.push(root);
        		root=root.left;
        	}else{
        		root=stack.pop();
        		result.add(root.val);
        		root=root.right;
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
