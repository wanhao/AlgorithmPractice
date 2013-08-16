package codinginterview;

public class LinkedListSorting {
	public static void main(String[] args){
		//1
		ListNode head=new ListNode(5);
		head.next=new ListNode(3);
		printList(mergeSort(head));
		
		//2
		head=new ListNode(5);
		head.next=new ListNode(3);
		head.next.next=new ListNode(6);
		printList(mergeSort(head));
		
		//3
		head=new ListNode(5);
		head.next=new ListNode(3);
		head.next.next=new ListNode(6);
		head.next.next.next=new ListNode(2);
		printList(mergeSort(head));

		//4
		head=new ListNode(5);
		head.next=new ListNode(3);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(3);
		printList(mergeSort(head));
	}
	
	public static void printList(ListNode head){
		while(head!=null){
			System.out.print(head.data+"->");
			head=head.next;
		}
		System.out.println();
	}
	
	public static ListNode mergeSort(ListNode head){
		if(head==null|| head.next==null) return head;
		
		ListNode slow=head;
		ListNode fast=head.next.next;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		ListNode right=slow.next;
		slow.next=null;
		
		ListNode leftHead=mergeSort(head);
		ListNode rightHead=mergeSort(right);
		return merge(leftHead,rightHead);
	}
	
	private static ListNode merge(ListNode left, ListNode right){
		if(left==null && right==null){
			return null;
		}else if(left==null){
			return right;
		}else if(right==null){
			return left;
		}
		ListNode head=null,current=null, tmp=null;
		while(left!=null && right!=null){
			if(left.data<=right.data){
				tmp=left;
				left=left.next;
			}else{
				tmp=right;
				right=right.next;
			}
			
			if(current==null){
				head=tmp;
				current=tmp;
			}else{
				current.next=tmp;
				current=current.next;
			}
		}
		
		if(left!=null){
			current.next=left;
		}
		if(right!=null){
			current.next=right;
		}
		return head;
	}
	
	static class ListNode{
		private int data;
		private ListNode next;
		
		public ListNode(int data){
			this.data=data;
			this.next=null;
		}
	}
}
