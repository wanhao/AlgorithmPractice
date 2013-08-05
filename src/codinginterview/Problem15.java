package codinginterview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Problem15 {
	public static void main(String args[]) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));

		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int n = (int) st.nval;
			st.nextToken();
			int k = (int) st.nval;

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
			ListNode kthNode = findKthToTail(head, k);
			System.out.println(kthNode == null ? "NULL" : kthNode.data);
		}
	}

	public static ListNode findKthToTail(ListNode head, int k) {
		if (k <= 0)
			return null;
		ListNode fast = head;
		for (int i = 0; i < k; i++) {
			if (fast != null) {
				fast = fast.next;
			} else {
				return null;
			}
		}

		ListNode slow = head;
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		return slow;
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
