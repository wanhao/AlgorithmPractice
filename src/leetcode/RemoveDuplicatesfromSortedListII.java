package leetcode;


public class RemoveDuplicatesfromSortedListII {

	
	public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode newhead=null;
        ListNode last=null;
        
        while(head!=null){
        	if(head.next==null || head.next.val!=head.val){
        		if(last==null){
        			newhead=head;
        			last=head;
        		}else{
        			last.next=head;
        			last=last.next;
        		}
        		head=head.next;
        	}else{
        		while(head.next!=null && head.next.val==head.val){
        			head=head.next;
        		}
        		head=head.next;
        	}
        }
        
        if(last!=null){
        	last.next=null;
        }
        
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
