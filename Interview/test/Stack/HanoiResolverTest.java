package Stack;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Stack.HanoiResolver.Tower;

public class HanoiResolverTest {

	@Test
	public void test_3_4() {
		List list = HanoiResolver.createHanoiTowers(5);
		HanoiResolver.moveHanoiTower((ArrayList<Tower<Integer>>) list);
		System.out.println();
	}

}
