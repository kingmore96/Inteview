package Queue;

import org.junit.Test;

public class MyQueueTest {

	@Test
	public void test_3_5() {
		MyQueue<Integer> queue = new MyQueue<>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		System.out.println(queue.peek());
	}

}
