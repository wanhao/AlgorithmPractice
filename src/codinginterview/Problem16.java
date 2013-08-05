package codinginterview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Problem16 {
	public static void main(String args[]) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));

		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int n = (int) st.nval;

			ListNode head = null, previous = null;
			for (int i = 0; i < n; i++) {
				st.nextToken();
				ListNode tmp = new ListNode((int) st.nval);
				if (previous == null) {
					head = tmp;
					previous = tmp;
				} else {
					previous.next = tmp;
					previous = tmp;
				}
			}
			ListNode newhead = reverseList(head);
			if(newhead==null){				
				System.out.println("NULL");
			}else{
				ListNode p=newhead;
				while(p!=null){
					System.out.print(p.data+" ");
					p=p.next;
				}
				System.out.println();
			}
		}
	}

	public static ListNode reverseList(ListNode head){
		ListNode current=head;
		head=null;
		ListNode tmp;
		while(current!=null){
			tmp=current.next;
			current.next=head;
			head=current;
			current=tmp;
		}
		
		return head;
	}

	static class ListNode {
		private int data;
		private ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
}
