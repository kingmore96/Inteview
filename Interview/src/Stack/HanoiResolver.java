package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class HanoiResolver {
	
	public static void moveHanoiTower(ArrayList<Tower<Integer>> list){
		if(list.isEmpty())
			System.out.println("塔不合法，请重新创建塔");
		Integer i = list.get(0).disks.get(0);
		Tower t0 = list.get(0);
		t0.moveDisks(i+1, list.get(2), list.get(1));
		Tower t3 = list.get(2);
	}
	
	public static List createHanoiTowers(int number){
		int n = 3;
		ArrayList<Tower<Integer>> list = new ArrayList<>(n);
		
		for(int i = 0;i<n;i++){
			list.add(i,new Tower<Integer>(i));
		}
		
		for(int i = number;i>=0;i--){
			list.get(0).add(i);
		}
		
		return list;
		
	}
	

	public static class Tower<T extends Comparable>{
		private Stack<T> disks;
		private int index;
		
		public Tower(int index) {
			this.disks = new Stack<T>();
			this.index = index;
		}
		
		public void add(T value){
			if(!disks.isEmpty() && disks.peek().compareTo(value) < 0){
				System.out.println("Error adding disk" + value);
			}
			else{
				disks.push(value);
			}
		}
		
		
		public void moveDisks(int n,Tower destination,Tower buffer){
			if(n>0){
				moveDisks(n-1, buffer, destination);
				moveTopTo(destination);
				buffer.moveDisks(n-1,destination ,this);
			}
		}
		
		public void moveTopTo(Tower<T> t){
			T top = disks.pop();
			t.add(top);
			System.out.println("Move disk " + top + " from " + index() + " to " + t.index());
		}

		public int index() {
			return index;
		}
		
	}
}
