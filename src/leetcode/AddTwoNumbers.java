package leetcode;

public class AddTwoNumbers {

	public static void main(String[] args) {

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry=0;
		ListNode head=null,last=null;
		
		while(l1!=null || l2!=null || carry!=0){
			int sum=carry;
			if(l1!=null){
				sum+=l1.val;
				l1=l1.next;
			}
			if(l2!=null){
				sum+=l2.val;
				l2=l2.next;
			}
			ListNode tmp=new ListNode(sum%10);
			if(last==null){
				head=tmp;
				last=tmp;
			}else{
				last.next=tmp;
				last=last.next;
			}
			carry=sum/10;
		}
		if(last!=null){
			last.next=null;
		}
		
		return head;
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
