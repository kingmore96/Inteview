package Stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class SetOfStacks<E> {
	//���ڼ�¼��ά��������Stack
	private ArrayList<Stack<E>> list = new ArrayList<>();
	//��¼���µ�Stack���������ȡֵ��Stack
	private Stack<E> currentStack;
	//ÿ��ջ���������
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
		//���ѡ�е���ջ�ǵ�ǰ������ջ
		if(stack == currentStack){
			//�����ջǰ�滹������ջ���Ҹ���ջ������û��Ԫ�أ���list��ɾ��
			if(currentStack.size() == 0 && list.size() > 1){
				list.remove(currentStack);
			}
		//���ǵ�ǰ������ջ����ǰ�������ջ
		}else{
			//�Ӵ�ɾ����ջ��ʼѭ����ʹ��listIterator�ĵõ�ջ��Ԫ�أ�ѹ���ɾ����ջ��Ȼ�����remove����ɾ����
			for(int i=index;i < list.size()-1;i++){
				Stack<E> s = list.get(i);
				Stack<E> next = list.get(i+1);
				Iterator<E> itr = next.listIterator(0);
				s.push(itr.next());
				itr.remove();
			}
			//�����ж���λ��������ջ�Ƿ�û������
			if(currentStack.size() == 0){
				list.remove(currentStack);
			}
		}
		return value;
	}
}
