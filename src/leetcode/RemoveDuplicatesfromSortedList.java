package leetcode;


public class RemoveDuplicatesfromSortedList {

	public static void main(String[] args) {

	}

    public ListNode deleteDuplicates(ListNode head) {
    	if(head==null || head.next==null) return head;
    	
    	ListNode newhead=head;
    	ListNode last=head;
    	head=head.next;
    	
    	while(head!=null){
    		if(head.val!=last.val){
    			last.next=head;
    			last=last.next;
    		}
    		head=head.next;
    	}
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
