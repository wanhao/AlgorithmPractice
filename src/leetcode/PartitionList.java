package leetcode;


public class PartitionList {

	public static void main(String[] args) {

	}

	public ListNode partition(ListNode head, int x) {
		if(head==null || head.next==null) return head;
		
		ListNode head1=null, last1=null;
		ListNode head2=null, last2=null;
		while(head!=null){
			if(head.val<x){
				if(last1==null){
					head1=head;
					last1=head;
				}else{
					last1.next=head;
					last1=last1.next;
				}
			}else{
				if(last2==null){
					head2=head;
					last2=head;
				}else{
					last2.next=head;
					last2=last2.next;
				}
			}
			
			head=head.next;
		}
		
		if(last1!=null){
			last1.next=null;
		}
		
		if(last2!=null){
			last2.next=null;
		}
		
		if(head1==null){
			return head2;
		}else{
			last1.next=head2;
			return head1;
		}
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
