package codinginterview;

import java.io.IOException;

public class Problem26 {
	public static void main(String args[]) throws IOException {
		ComplexListNode head=new ComplexListNode(1);
		head.next=new ComplexListNode(2);
		head.next.next=new ComplexListNode(3);
		head.next.next.next=new ComplexListNode(4);
		head.sibling=head.next.next;
		head.next.next.sibling=head.next;
		
		printList(head);
		printList(copyList(head));
	}

	public static void printList(ComplexListNode head){
		ComplexListNode tmp=head;
		StringBuilder sb=new StringBuilder();
		while(tmp!=null){
			sb.append(tmp.data+"["+(tmp.sibling==null?null:tmp.sibling.data)+"] -> ");
			tmp=tmp.next;
		}
		System.out.println(sb.toString());
	}
	
	public static ComplexListNode copyList(ComplexListNode head){
		ComplexListNode current=head;
		while(current!=null){
			ComplexListNode tmp=new ComplexListNode(current.data);
			tmp.next=current.next;
			current.next=tmp;
			
			current=tmp.next;
		}
		
		current=head;
		while(current!=null){
			if(current.sibling!=null){
				current.next.sibling=current.sibling.next;
			}
			current=current.next.next;
		}
		
		ComplexListNode copyhead=null, last=null, copylast=null;
		if(head!=null){
			copyhead=head.next;
			current=head.next.next;
			last=head;
			copylast=copyhead;
		}
		
		while(current!=null){
			last.next=current;
			last=last.next;
			copylast.next=current.next;
			copylast=copylast.next;
			
			current=current.next.next;
		}
		
		if(last!=null){
			last.next=null;
		}
		if(copylast!=null){
			copylast.next=null;
		}
		
		return copyhead;
	}

	static class ComplexListNode {
		private int data;
		private ComplexListNode next, sibling;

		public ComplexListNode(int data) {
			this.data = data;
			this.next = null;
			this.sibling = null;
		}
	}
}
