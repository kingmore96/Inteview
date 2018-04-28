package Array;

public class ArrayUtil {
	public static void rotateRight(int[][] matrix,int n){
		for(int layer = 0;layer< n/2;layer++){
			int first = layer;
			int last = n-1-layer;
			for(int i=first;i<last;i++){
				int offset = i-first;
				int top = matrix[first][i];
				matrix[first][i] = matrix[last-offset][first];
				matrix[last-offset][first] = matrix[last][last-offset];
				matrix[last][last-offset] = matrix[i][last];
				matrix[i][last] = top;
			}
		}
	}
	
	public static void rotateLeft(int[][] matrix,int n){
		for(int layer = 0;layer<n/2;layer++){
			int first = layer;
			int last = n-1-layer;
			for(int i=first;i<last;i++){
				int offset = i-first;
				int top = matrix[first][i];
				matrix[first][i] = matrix[i][last];
				matrix[i][last] = matrix[last][last-offset];
				matrix[last][last-offset] = matrix[last-offset][first];
				matrix[last-offset][first] = top;
			}
		}
	}
	
	public static void setZeros(int[][] matrix){
		boolean[] rows = new boolean[matrix.length];
		boolean[] columns = new boolean[matrix[0].length];
		
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(matrix[i][j] == 0){
					rows[i] = true;
					columns[j] = true;
				}
			}
		}
		
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(rows[i] || columns[j]){
					matrix[i][j] = 0;
				}
			}
		}
	}
}
