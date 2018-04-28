package Queue;

import java.util.Stack;

public class MyQueue<T> {
	private Stack<T> stackNewest;
	private Stack<T> stackOldest;
	
	public MyQueue() {
		this.stackNewest = new Stack<>();
		this.stackOldest = new Stack<>();
	}
	
	public void add(T value){
		stackNewest.push(value);
	}
	
	public T peek(){
		shiftStacks();
		return stackOldest.peek();
	}
	
	public T remove(){
		shiftStacks();
		return stackOldest.pop();
	}
	
	public int size(){
		return stackNewest.size() + stackOldest.size();
	}
	
	private void shiftStacks() {
		if(stackOldest.isEmpty()){
			while(!stackNewest.isEmpty()){
				stackOldest.push(stackNewest.pop());
			}
		}
	}
}
