package Array;

import org.junit.Test;

public class ArrayUtilTest {

	@Test
	public void test_1_6() {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		ArrayUtil.rotateRight(matrix, 4);
		//ArrayUtil.rotateLeft(matrix, 4);
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(j<3)
					System.out.print(matrix[i][j]+" ");
				else
					System.out.println(matrix[i][j]);
			}
		}
	}
	
	@Test
	public void test_1_7(){
		int[][] matrix = {{1,0,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		ArrayUtil.setZeros(matrix);
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(j<3)
					System.out.print(matrix[i][j]+"\t");
				else
					System.out.println(matrix[i][j]);
			}
		}
	}

}
