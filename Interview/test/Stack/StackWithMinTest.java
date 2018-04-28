package Stack;

import org.junit.Test;

public class StackWithMinTest {

	@Test
	public void test_3_2() {
		StackWithMin stack = new StackWithMin();
		stack.push(3);
		System.out.println(stack.min());
		stack.push(3);
		System.out.println(stack.min());
		stack.push(3);
		System.out.println(stack.min());
		stack.push(7);
		System.out.println(stack.min());
		
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		
		System.out.println();;
		
		while(!stack.s2.isEmpty()){
			System.out.println(stack.s2.pop());
		}
		
	}

}
