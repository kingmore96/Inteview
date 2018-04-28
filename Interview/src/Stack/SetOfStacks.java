package Stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class SetOfStacks<E> {
	//用于记录所维护的所有Stack
	private ArrayList<Stack<E>> list = new ArrayList<>();
	//记录最新的Stack，待存入和取值的Stack
	private Stack<E> currentStack;
	//每个栈的最大容量
	private static final int MAX_CAP = 100; 
	
	public SetOfStacks(){
		Stack<E> stack = new Stack<>();
		list.add(stack);
		currentStack = stack;
	}
	
	public void push(E value){
		if(currentStack.size() >= MAX_CAP){
			Stack<E> newStack = new Stack<>();
			newStack.push(value);
			list.add(newStack);
			currentStack = newStack;
		}
		else{
			currentStack.push(value);
		}
	}
	
	public E pop(){
		E value = currentStack.pop();;
		if(currentStack.size() == 0 && list.size() > 1){
			list.remove(currentStack);
			currentStack = list.get(list.size()-1);
		}
		return value;
	}
	
	public E peek(){
		if(isEmpty()){
			return null;
		}
		return currentStack.peek();
	}

	public boolean isEmpty() {
		return list.size() ==1 && currentStack.size() == 0;
	}
	
	public E popAt(int index){
		if(index > list.size()-1){
			return null;
		}
		Stack<E> stack = list.get(index);
		E value = stack.pop();
		//如果选中的子栈是当前最新子栈
		if(stack == currentStack){
			//如果子栈前面还有满子栈，且该子栈弹出后没有元素，从list中删除
			if(currentStack.size() == 0 && list.size() > 1){
				list.remove(currentStack);
			}
		//不是当前最新子栈，是前面的满子栈
		}else{
			//从待删除子栈开始循环，使用listIterator的得到栈底元素，压入待删除子栈，然后调用remove方法删除。
			for(int i=index;i < list.size()-1;i++){
				Stack<E> s = list.get(i);
				Stack<E> next = list.get(i+1);
				Iterator<E> itr = next.listIterator(0);
				s.push(itr.next());
				itr.remove();
			}
			//这里判断移位后最新子栈是否没有数据
			if(currentStack.size() == 0){
				list.remove(currentStack);
			}
		}
		return value;
	}
}
