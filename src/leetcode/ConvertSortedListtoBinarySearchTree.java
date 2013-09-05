package leetcode;

public class ConvertSortedListtoBinarySearchTree {

	public static void main(String[] args) {

	}

	public TreeNode sortedListToBST(ListNode head) {
		if(head==null) return null;
		if(head.next==null) return new TreeNode(head.val);
		
		ListNode fast=head.next.next;
		ListNode slow=head;
		while(fast!=null && fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
		}
		
		ListNode tmp=slow.next;
		slow.next=null;

		TreeNode root=new TreeNode(tmp.val);
		root.left=sortedListToBST(head);
		root.right=sortedListToBST(tmp.next);
		
		return root;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
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
