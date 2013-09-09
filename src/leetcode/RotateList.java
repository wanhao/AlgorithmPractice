package leetcode;

public class RotateList {

	public ListNode rotateRight(ListNode head, int n) {
		if(head==null || n<=0) return head;
		
		int len=0;
		ListNode pointer=head;
		while(pointer!=null){
			len++;
			pointer=pointer.next;
		}
		
		n=len-(n%len);
		if(n==len) return head;
		
		pointer=head;
		int count=0;
		while(pointer!=null){
			count++;
			if(count>=n) break;
			pointer=pointer.next;
		}
		ListNode last=pointer;
		ListNode newhead=pointer.next;
		
		while(pointer.next!=null){
			pointer=pointer.next;
		}
		pointer.next=head;
		last.next=null;
		
		return newhead;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
