package Linkedlist;

import java.util.HashMap;

public class LinkedListUtil {

	public static <E> void deleteDuplicateNode1(Node<E> head){
		HashMap<E,Boolean> map = new HashMap<>();
		Node<E> current = head;
		Node<E> previous = null;
		
		while(current != null){
			if(map.containsKey(current.item)){
				previous.next = current.next;
			}
			else{
				map.put(current.item, true);
				previous = current;
			}
			current = current.next;
		}
	}
	
	public static <E> void deleteDuplicateNode2(Node<E> head){
		Node<E> current = head;
		while(current.next != null){
			Node<E> runner = current.next;
			do{
				if(runner.item == current.item){
					current.next = runner.next;
				}
			}while((runner = runner.next) != null);
			current = current.next;
		}
	}
	
	public static <E> Node<E> nthToLast(Node<E> head, int k, IntWrapper i){
		if(head == null)
			return null;
		Node<E> node = nthToLast(head.next,k,i);
		i.value = i.value + 1;
		if(i.value == k)
			return head;
		return node;
	}
	
	public static <E> Node<E> nthToLast(Node<E> head,int k){
		Node<E> p1 = head;
		Node<E> p2 = head;
		
		for(int i=0;i < k-1 ;i++){
			if(p2 == null) return null;
			p2 = p2.next;
		}
		
		while(p2.next != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
	
	public static <E> void removeOneNode(Node<E> node){
		if(node == null)
			return ;
		if(node.next != null){
			swapItem(node,node.next);
			node.next = node.next.next;
		}
		else{
			node.isValid = false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Node<T> partition(Node<? extends Comparable<T>> node,T x){
		Node beforeStart = null;
		Node afterStart = null;
		
		while(node != null){
			Node next = node.next;
			if(node.item == null){
				node = node.next;
			}
			else if(node.item.compareTo(x) < 0){
				node.next = beforeStart;
				beforeStart = node;
			}
			else{
				node.next = afterStart;
				afterStart = node;
			}
			node = next;
		}
		
		if(beforeStart == null)
			return afterStart;
		
		Node head = beforeStart;
		while(beforeStart.next != null){
			beforeStart = beforeStart.next;
		}
		beforeStart.next = afterStart;
		
		return head;
	}
	
	//TODO
	public static <E> Node<Integer> addTwoListForward(Node<Integer> head1,Node<Integer> head2){
		Node<Integer> newHead1 = reverseList(head1);
		Node<Integer> newHead2 = reverseList(head2);
		
		Node<Integer> tempResult = addTwoListReverse(newHead1, newHead2);
		Node<Integer> finalResult = reverseList(tempResult);
		return finalResult;
	}
	
	public static <E> Node<E> reverseList(Node<E> head) {
		Node<E> newHead = new Node<E>(head.item);
		newHead.next = null;
		
		if(head.next == null)
			return head;
		
		Node<E> p = head.next;
		
		while(p!=null){
			Node<E> newN = new Node<E>(p.item);
			newN.next = newHead;
			newHead = newN;
			p = p.next;
		}
		
		return newHead;
	}

	public static Node<Integer> addTwoListReverse(Node<Integer> head1,Node<Integer> head2){
		if(head1 == null && head2 == null)
			return null;
		
		Node<Integer> p = head1;
		Node<Integer> q = head2;
		Node<Integer> head = null;
		Node<Integer> tail = null;
		boolean isCarried = false;
		
		while(p != null || q != null){
			Result result = null;
			if(p == null){
				result = doAdd(0,q.item,isCarried);
			}
			else if(q == null){
				result = doAdd(p.item,0,isCarried);
			}
			else{
				result = doAdd(p.item,q.item,isCarried);
			}
			
			Node<Integer> newNode = new Node<Integer>(result.digit);
			if(head == null){
				newNode.next = head;
				head = newNode;
				tail = newNode;
			}else{
				tail.next = newNode;
				newNode.next = null;
				tail = newNode;
			}
			
			if(result.isCarried){
				isCarried = true;
			}
			else{
				isCarried = false;
			}
			
			if(p == null){
				q = q.next;
			}
			else if(q == null){
				p = p.next;
			}
			else{
				p = p.next;
				q = q.next;
			}
			
		}
		
		return head;
	}
	
	public static <E> Node<E> isCircle(Node<E> head){
		if(head == null || head.next == null)
			return null;
		
		HashMap map = new HashMap<>();
		Node<E> p = head;
		map.put(p.hashCode(), null);
		
		while(p.next != null){
			if(map.containsKey(p.next.hashCode())){
				return p.next;
			}
			else{
				map.put(p.next.hashCode(), null);
			}
			p = p.next;
		}
		return null;
	}

	public static <E> boolean isPalindorm(Node<E> head){
		Node<E> newHead = reverseList(head);
		Node<E> p = head;
		Node<E> q = newHead;
		while(p != null){
			if(p.item.equals(q.item)){
				p = p.next;
				q = q.next;
			}
			else{
				return false;
			}
		}
		return true;
		
	}
	
	private static Result doAdd(Integer item1, Integer item2, boolean isCarried) {
		Result result = new Result();
		if(!isCarried){
			int temp = item1 + item2;
			if(temp>10){
				result.digit = temp % 10;
				result.isCarried = true;
			}
			else{
				result.digit = temp;
				result.isCarried = false;
			}
		}else{
			int temp = item1 + item2 + 1;
			if(temp >= 10){
				result.digit = temp % 10;
				result.isCarried = true;
			}
			else{
				result.digit = temp;
				result.isCarried = false;
			}
		}
		return result;
	}

	public static <E> void swapItem(Node<E> node, Node<E> next) {
		E temp = node.item;
		node.item = next.item;
		next.item = temp;
	}

	public static class Result{
		int digit;
		boolean isCarried;
	}
	public static class Node<E>{
		private E item;
		private Node<E> next;
		private boolean isValid = true;
		
		public boolean isValid() {
			return isValid;
		}
		public Node(E item) {
			this.item = item;
		}
		public E getItem() {
			return item;
		}
		public void setItem(E item) {
			this.item = item;
		}
		public Node<E> getNext() {
			return next;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}
		@Override
		public String toString() {
			return "Node [item=" + item + "]";
		}
	}
	
	
	public static class IntWrapper{
		public int value = 0;
	}
}
