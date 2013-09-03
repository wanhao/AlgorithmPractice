package codinginterview;

import java.util.Arrays;


public class PeekableQueueImpl<E extends Comparable<E>> implements
		PeekableQueue<E> {
	private ListNode<E> head = null, last = null;
	private Object[] sortedList = null;
	private int size = 0;

	public PeekableQueueImpl() {
		this.head = null;
		this.last = null;
		this.sortedList = new Object[5];
		this.size = 0;
	}

	@Override
	public void enqueue(E e) {
		if(e==null) throw new IllegalArgumentException();
		
		if (size <= 0) {
			head = new ListNode<E>(e);
			last = head;
			sortedList[0] = e;
			size = 1;
		} else {
			last.next = new ListNode<E>(e);
			last = last.next;
			
			if(size>=sortedList.length){
				Object[] tmp=new Object[sortedList.length<<1];
				for(int i=0;i<size;i++){
					tmp[i]=sortedList[i];
				}
				sortedList=tmp;
			}
			
			int location=binarySearch(e);
			for(int i=size-1;i>=location;i--){
				sortedList[i+1]=sortedList[i];
			}
			sortedList[location]=e;
			size++;
		}
	}

	private int binarySearch(E e) {
		int low = 0, high = size - 1;
		int middle = -1;
		int cmp=0;
		while (low <= high) {
			middle = low + ((high - low) >> 1);
			cmp=((E)sortedList[middle]).compareTo(e);
			if(cmp==0){
				return middle;
			}else if(cmp>0){
				high=middle-1;
			}else{
				low=middle+1;
			}
		}
		
		return low;
	}

	@Override
	public E dequeue() {
		if(size<=0) throw new IllegalStateException("empty queue");
		
		E toRemove=head.data;
		head=head.next;
		
		int location=binarySearch(toRemove);
		for(int i=location;i<size;i++){
			sortedList[i]=sortedList[i+1];
		}
		size--;
		return toRemove;
	}

	@Override
	public E peekMedian() {
		if((size & 1)==0){
//			return (sortedList[size>>1]+sortedList[(size>>1)-1])/2;
			return (E)sortedList[size>>1];
		}else{
			return (E)sortedList[size>>1];
		}
	}

	@Override
	public E peekMaximum() {
		if(size<=0)throw new IllegalStateException("empty queue");
		
		return (E)sortedList[size-1];
	}

	@Override
	public E peekMinimum() {
		if(size<=0)throw new IllegalStateException("empty queue");
		return (E)sortedList[0];
	}

	@Override
	public int size() {
		return size;
	}

	static class ListNode<E> {
		private E data;
		private ListNode<E> next;

		public ListNode(E e) {
			this.data = e;
			this.next = null;
		}
	}
	
	public static void main(String[] args){
		PeekableQueueImpl<Integer> queue=new PeekableQueueImpl<Integer>();
		
		queue.enqueue(10);
		System.out.println(queue.dequeue());
		
		queue.enqueue(10);
		System.out.println(Arrays.toString(queue.sortedList));
		queue.enqueue(40);
		System.out.println(Arrays.toString(queue.sortedList));
		queue.enqueue(10);
		System.out.println(Arrays.toString(queue.sortedList));
		queue.enqueue(30);
		System.out.println(Arrays.toString(queue.sortedList));
		queue.enqueue(3);
		System.out.println(Arrays.toString(queue.sortedList));
		queue.enqueue(7);
		System.out.println(Arrays.toString(queue.sortedList));
		queue.enqueue(10);
		System.out.println(Arrays.toString(queue.sortedList));
		queue.enqueue(9);
		System.out.println(Arrays.toString(queue.sortedList));
		
		System.out.println(queue.dequeue());
		System.out.println(Arrays.toString(queue.sortedList));
		System.out.println(queue.dequeue());
		System.out.println(Arrays.toString(queue.sortedList));
		System.out.println(queue.dequeue());
		System.out.println(Arrays.toString(queue.sortedList));
	}
}

interface PeekableQueue<E extends Comparable<E>> {

	public void enqueue(E e);

	public E dequeue();

	public E peekMedian();

	public E peekMaximum();

	public E peekMinimum();

	public int size();
}
