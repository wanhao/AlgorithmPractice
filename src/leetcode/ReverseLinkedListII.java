package leetcode;

public class ReverseLinkedListII {

	public static void main(String[] args) {
		ReverseLinkedListII t=new ReverseLinkedListII();
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		t.print(t.reverseBetween(head,2,3));
	}

	public void print(ListNode root) {
		while (root != null) {
			System.out.print(root.val + "->");
			root = root.next;
		}
		System.out.println();
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n)
			return head;

		ListNode leftLast = null, mPointer = null, nPointer = null;
		int count = 0;
		ListNode current = head;
		while (current != null) {
			count++;
			if (count == m) {
				mPointer = current;
			}
			if (count == n) {
				nPointer = current;
				break;
			}
			if (count < m) {
				leftLast = current;
			}
			current = current.next;
		}

		ListNode rightHead = nPointer.next;
		ListNode tmp = null;
		while (true) {
			tmp = mPointer.next;
			mPointer.next = rightHead;
			rightHead = mPointer;

			if (mPointer == nPointer) {
				break;
			}
			mPointer = tmp;
		}

		if (leftLast == null) {
			return rightHead;
		} else {
			leftLast.next = rightHead;
			return head;
		}

	}

}
