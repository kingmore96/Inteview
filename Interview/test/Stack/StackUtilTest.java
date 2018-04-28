package Stack;

import java.util.Stack;

import org.junit.Test;

public class StackUtilTest {

	@Test
	public void test_3_6() {
		Stack<Integer> s = new Stack<Integer>();
		s.push(5);
		s.push(10);
		s.push(7);
		s.push(3);
		s.push(13);
		s.push(2);
		StackUtil.stackToArraySort(s);
		System.out.println();
	}

}
