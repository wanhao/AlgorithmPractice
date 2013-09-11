package leetcode;

public class RemoveNthNodeFromEndofList {

	public static void main(String[] args) {

	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast=head,slow=head;
		int count=0;
		while(count<n){
			count++;
			fast=fast.next;
		}
		
		ListNode last=null;
		while(fast!=null){
			fast=fast.next;
			last=slow;
			slow=slow.next;
		}
		if(last==null){
			return slow.next;
		}else{
			last.next=slow.next;
			return head;
		}
	}

}
