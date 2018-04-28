package Stack;

public class StackUsingArr_FixedSize {
	private int stackSize;
	private int[] buffer ;
	private int[] stackPointer;
	
	public StackUsingArr_FixedSize(int stackSize,int num) {
		this.stackSize = stackSize;
		this.buffer = new int[stackSize * num];
		this.stackPointer = new int[num];
		
		for(int i = 0;i<num;i++){
			stackPointer[i] = -1;
		}
		
	}
	
	public void push(int stackNum,int value) throws Exception{
		if(stackPointer[stackNum] + 1 >= stackSize){
			throw new Exception("Out of space");
		}
		
		stackPointer[stackNum]++;
		buffer[absTopOfStack(stackNum)] = value;
	}

	public int pop(int stackNum) throws Exception{
		if(stackPointer[stackNum] == -1){
			throw new Exception("Trying to pop an empty stack");
		}
		
		int value = buffer[absTopOfStack(stackNum)];
		buffer[absTopOfStack(stackNum)] = 0;
		stackPointer[stackNum]--;
		return value;
	}
	
	public int peek(int stackNum) throws Exception{
		if(isEmpty(stackNum)){
			throw new Exception("the stack is empty");
		}
		
		return buffer[absTopOfStack(stackNum)];
	}
	
	public boolean isEmpty(int stackNum) throws Exception{
		if(stackNum > stackPointer.length - 1)
			throw new Exception("Out of stack number index boundary");
		
		return stackPointer[stackNum] == -1;
	}
	
	private int absTopOfStack(int stackNum) throws Exception {
		if(stackNum > stackPointer.length - 1)
			throw new Exception("Out of stack number index boundary");
		
		return stackNum * stackSize + stackPointer[stackNum];
	}
	
}
