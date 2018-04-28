package Linkedlist;

import org.junit.Test;

import Linkedlist.LinkedListUtil.IntWrapper;
import Linkedlist.LinkedListUtil.Node;

public class LinkedListUtilTest {

	@Test
	public void test_2_1() {
		Node<Integer> head = new Node<Integer>(0);
		Node<Integer> p = head;
		Node<Integer> node ;
		for(int i = 1;i < 200000;i++){
			if(i<100000){
				p.setNext(new Node<Integer>(i));
			}
			else{
				p.setNext(new Node<Integer>(i%100000));
			}
			p = p.getNext();
		}
		
		printNodeList(head);
		
		long start = System.currentTimeMillis();
		//LinkedListUtil.deleteDuplicateNode1(head);
		LinkedListUtil.deleteDuplicateNode2(head);
		long end = System.currentTimeMillis();
		System.out.println("time is " + (end - start));
		
		System.out.println("------------------------------");
		
		printNodeList(head);
	}
	
	@Test
	public void test_2_2(){
		Node<Integer> head = new Node<Integer>(0);
		head = createIntegerNode(head,1000);
		long start = System.currentTimeMillis();
		Node<Integer> node = LinkedListUtil.nthToLast(head, 1000);
		long end = System.currentTimeMillis();
		System.out.println("time is " + (end - start));
		System.out.println(node.toString());
		
		long start2 = System.currentTimeMillis();
		Node<Integer> node1 = LinkedListUtil.nthToLast(head, 1000,new IntWrapper());
		long end2 = System.currentTimeMillis();
		System.out.println("time is " + (end2 - start2));
		System.out.println(node1.toString());
	}
	
	@Test
	public void test_2_3(){
		Node<Integer> head = new Node<>(0);
		createIntegerNode(head, 2);
		printNodeList(head);
		System.out.println("-------------------");
		LinkedListUtil.removeOneNode(head.getNext());
		printNodeList(head);
	}
	
	@Test
	public void test_2_4(){
		Node<Integer> head = new Node<>(0);
		createIntegerNode(head, 20);
		printNodeList(head);
		System.out.println();
		head = LinkedListUtil.partition(head, 5);
		printNodeList(head);
	}
	
	@Test
	public void test_2_5_Reverse(){
		Node<Integer> head1 = new Node<>(0);
		createIntegerNode(head1, 10);
		Node<Integer> head2 = new Node<>(0);
		createIntegerNode(head2, 20);
		printNodeList(head1);
		printNodeList(head2);
		Node<Integer> result = LinkedListUtil.addTwoListReverse(head1, head2);
		printNodeList(result);
	}
	
	@Test
	public void test_2_5_Forward(){
		Node<Integer> head1 = new Node<>(1);
		createIntegerNode(head1, 20);
		Node<Integer> head2 = new Node<>(1);
		createIntegerNode(head2, 10);
		printNodeList(head1);
		printNodeList(head2);
		System.out.println("--------------------");
		Node<Integer> result = LinkedListUtil.addTwoListForward(head1, head2);
		printNodeList(result);
	}
	
	@Test
	public void test_2_6(){
		Node<Integer> head = new Node<>(0);
		createIntegerNode(head, 20);
		printNodeList(head);
		
		Node<Integer> p = head;
		while(p.getNext()!=null){
			p = p.getNext();
		}
		p.setNext(head);
		
		System.out.println(LinkedListUtil.isCircle(head));
	
	}
	
	@Test 
	public void test_2_7(){
		Node<Integer> head = new Node<>(0);
		Node<Integer> p = head;
		for(int i = 1; i<5;i++){
			if(i<=2)
				p.setNext(new Node<Integer>(i));
			else{
				p.setNext(new Node<Integer>(4-i));
			}
			p = p.getNext();
		}
		printNodeList(head);
		System.out.println(LinkedListUtil.isPalindorm(head));
	}
	
	
	private Node<Integer> createIntegerNode(Node<Integer> head,int number){
		Node<Integer> p = head;
		for(int i = 1;i < number;i++){
			if(i<(number/2)){
				p.setNext(new Node<Integer>(i));
			}
			else{
				p.setNext(new Node<Integer>(i%(number/2)));
			}
			p = p.getNext();
		}
		return head;
	}
	
	private <E> void printNodeList(Node<E> head){
		Node<E> node = head;
		while(node != null && node.isValid()){
			System.out.print(node.getItem() + " ");
			node = node.getNext();
		}
		System.out.println();
	}

}
