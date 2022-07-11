package july;

public class Search2DMatrix {
	
	public int getIdx(int i, int j, int n) {
		return i * n + j;
	}
	
	public boolean binarySearch(int[][] matrix, int target, int low, int hi) {

    	int n = matrix[0].length;
		
		if (low > hi)
			return false;
		
		else {
			int mid = (low + hi)/2;
			
			if (matrix[mid/n][mid%n] == target)
				return true;
			
			else if (target > matrix[mid/n][mid%n]) {
				return binarySearch(matrix, target, mid+1, hi);
			}
			else {
				return binarySearch(matrix, target, low, mid-1);
			}
		}
	}
	
    public boolean searchMatrix(int[][] matrix, int target) {
        
    	int low = getIdx(0, 0, matrix[0].length);
    	int high = getIdx(matrix.length-1, matrix[0].length-1, matrix[0].length);

    	return binarySearch(matrix, target, low, high);
    }

}
