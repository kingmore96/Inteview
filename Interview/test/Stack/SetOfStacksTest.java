package Stack;

import org.junit.Test;

public class SetOfStacksTest {

	@Test
	public void test_3_3() {
		SetOfStacks<Integer> setOfStacks = new SetOfStacks<>();
		for(int i = 0 ;i<201;i++){
			setOfStacks.push(i);
		}
		System.out.println(setOfStacks.peek());
		
		System.out.println(setOfStacks.pop());
	}
	
	@Test
	public void test_3_3_Advance(){
		SetOfStacks<Integer> setOfStacks = new SetOfStacks<>();
		for(int i = 0 ;i<201;i++){
			setOfStacks.push(i);
		}
		setOfStacks.popAt(0);
	}

}
