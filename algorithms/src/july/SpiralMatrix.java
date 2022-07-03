package july;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	
    public List<Integer> spiralOrder(int[][] matrix) {
    	
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    		return new ArrayList<Integer>();
    	}
    	
        List<Integer> result = new ArrayList<Integer>();
        
        int top = 0, down = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (left <= right && top <= down) {
        	// Top, left to right
        	for (int i = top, j = left; j <= right; j++) {
            	result.add(matrix[i][j]);
            }
        	top++;
        	
        	// Right, top to down
        	for (int j = right, i = top; i <= down; i++) {
        		result.add(matrix[i][j]);
        	}
        	right--;
        	
        	// Bottom, right to left
        	for (int i = down, j = right; j >= left && top <= down; j--) {
        		result.add(matrix[i][j]);
        	}
        	down--;
        	
        	// Left, bottom to up
        	for (int j = left, i = down; i >= top && left <= right; i--) {
        		result.add(matrix[i][j]);
        	}
        	left++;
        }
        

        return result;
    }

}
