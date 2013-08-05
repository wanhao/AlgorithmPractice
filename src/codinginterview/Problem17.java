package codinginterview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Problem17 {
	public static void main(String args[]) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));

		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int n = (int) st.nval;
			st.nextToken();
			int m = (int) st.nval;

			ListNode head1 = null, previous = null;
			for (int i = 0; i < n; i++) {
				st.nextToken();
				ListNode tmp = new ListNode((int) st.nval);
				if (previous == null) {
					head1 = tmp;
					previous = tmp;
				} else {
					previous.next = tmp;
					previous = tmp;
				}
			}
			
			ListNode head2 = null;
			previous = null;
			for (int i = 0; i < m; i++) {
				st.nextToken();
				ListNode tmp = new ListNode((int) st.nval);
				if (previous == null) {
					head2 = tmp;
					previous = tmp;
				} else {
					previous.next = tmp;
					previous = tmp;
				}
			}
			
			ListNode newhead = mergeList(head1,head2);
			if(newhead==null){				
				System.out.println("NULL");
			}else{
				StringBuilder sb=new StringBuilder();
				ListNode p=newhead;
				sb.append(p.data);
				p=p.next;
				while(p!=null){
					sb.append(" ");
					sb.append(p.data);
					p=p.next;
				}
				System.out.println(sb.toString());
			}
		}
	}

	public static ListNode mergeList(ListNode list1,ListNode list2){
		if(list1==null){
			return list2;
		}else if(list2==null){
			return list1;
		}
		
		ListNode head=null,last=null;
		ListNode tmp=null;
		while(list1!=null && list2!=null){
			if(list1.data<=list2.data){
				tmp=list1;
				list1=list1.next;
			}else{
				tmp=list2;
				list2=list2.next;
			}
			
			tmp.next=null;
			if(last==null){
				head=tmp;
				last=tmp;
			}else{
				last.next=tmp;
				last=last.next;
			}
		}
		
		if(list1!=null){
			last.next=list1;
		}
		
		if(list2!=null){
			last.next=list2;
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
