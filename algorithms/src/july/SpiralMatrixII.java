package july;

public class SpiralMatrixII {
	
    public int[][] generateMatrix(int n) {
    	
    	int[][] matrix = new int[n][n];
    	int shang = 0, xia = n - 1, left = 0, right = n-1;
    	
    	int val = 1;
    	
    	while (shang <= xia && left <= right) {
    		// Top, from left to right
        	for (int i = left; i <= right; i++) {
        		matrix[shang][i] = val;
        		++val;
        	}
        	++shang;
        	
        	// Right, from top to down
        	for (int i = shang; i <= xia; i++) {
        		matrix[i][right] = val;
        		++val;
        	}
        	--right;
        	
        	// Bottom, from right to left
        	for (int i = right; i >= left && shang <= xia; i--) {
        		matrix[xia][i] = val;
        		++val;
        	}
        	--xia;
        	
        	// Left, bottom up
        	for (int i = xia; i >= shang && left <= right; i--) {
        		matrix[i][left] = val;
        		++val;
        	}
        	++left;
    	}

    	return matrix;
    }

}
