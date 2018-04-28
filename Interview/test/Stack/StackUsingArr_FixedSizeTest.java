package Stack;

import org.junit.Test;

public class StackUsingArr_FixedSizeTest {

	@Test
	public void test_3_1() throws Exception {
		StackUsingArr_FixedSize stack = new StackUsingArr_FixedSize(100, 3);
		try {
			stack.pop(0);
		} catch (Exception e) {
			System.out.println("ø’’ª");
		}
		for(int i=0;i<101;i++){
			try {
				stack.push(0, i);
			} catch (Exception e) {
				System.out.println("’ª¬˙¡À");
			}
		}
		
		try {
			stack.peek(2);
			
		} catch (Exception e) {
			System.out.println("ø’’ª");
		}
		System.out.println(stack.peek(0));
	}

}
