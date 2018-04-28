package Stack;

import java.util.Arrays;
import java.util.Stack;

public class StackUtil {
	
	public static Stack<Integer> sort(Stack<Integer> s){
		Stack<Integer> result = new Stack<Integer>();
		while(!s.isEmpty()){
			Integer value = s.pop();
			while(!result.isEmpty() && result.peek() > value){
				s.push(result.pop());
			}
			result.push(value);
		}
		return result;
	}
	
	public static void stackToArraySort(Stack<Integer> s){
		Object[] anArray = new Object[s.size()];
		s.copyInto(anArray);
		Arrays.sort(anArray);
		for(int i = 0;i<s.size();i++){
			s.set(i, (Integer)anArray[i]);
		}
	}
	
	public static Stack<Integer> quickSort(Stack<Integer> s){
		qSort(s,0,s.size()-1);
		return s;
	}

	private static void qSort(Stack<Integer> s, int low, int high) {
		int pivot;
		if(low<high){
			pivot = partition(s,low,high);
			qSort(s,low,pivot-1);
			qSort(s,pivot+1,high);
		}
	}

	private static int partition(Stack<Integer> s, int low, int high) {
		int pivotKey = s.get(low);
		while(low < high){
			while(low < high && s.get(high)>=pivotKey)
				high--;
			swap(s,low,high);
			
			while(low < high && s.get(low)<= pivotKey)
				low++;
			
			swap(s,low,high);
		}
		return low;
	}

	private static void swap(Stack<Integer> s, int low, int high) {
		int temp = s.get(low);
		s.set(low,s.get(high));
		s.set(high, temp);
	}
	
}
