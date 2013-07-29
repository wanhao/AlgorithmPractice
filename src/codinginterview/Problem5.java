package codinginterview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem5 {
	public static void main(String args[]) throws IOException {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String line=null;
		while((line=reader.readLine())!=null){
			Node head=new Node(Integer.valueOf(line),null);
			Node tmp=head;
			while((line=reader.readLine())!=null && Integer.valueOf(line)!=-1){
				tmp.next=new Node(Integer.valueOf(line),null);
				tmp=tmp.next;
			}
			printList(head);
		}
		
	}
	
	public static void printList(Node head){
//		if(head!=null){
//			printList(head.next);
//			System.out.println(head.data);
//		}
		Stack<Node> stack=new Stack<Node>();
		while(head!=null){
			stack.push(head);
			head=head.next;
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop().data);
		}
	}

	static class Node{
		private int data;
		private Node next;
		
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
		
	}
}


