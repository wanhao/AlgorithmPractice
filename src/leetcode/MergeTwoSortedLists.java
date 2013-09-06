package leetcode;

public class MergeTwoSortedLists {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		
		ListNode head=null, last=null;
		ListNode tmp=null;
		while(l1!=null && l2!=null){
			if(l1.val<l2.val){
				tmp=l1;
				l1=l1.next;
			}else{
				tmp=l2;
				l2=l2.next;
			}
			
			if(last==null){
				head=tmp;
				last=tmp;
			}else{
				last.next=tmp;
				last=last.next;
			}
		}
		
		if(l1!=null){
			last.next=l1;
		}else if(l2!=null){
			last.next=l2;
		}else{
			last.next=null;			
		}
		
		return head;
	}
}
