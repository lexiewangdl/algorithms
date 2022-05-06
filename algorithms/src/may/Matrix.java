package may;

import java.util.Arrays;

public class Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];
        for (int k = 0; k < mat.length; k++) {
        	Arrays.fill(result[k], (int) Math.ceil(Math.sqrt(mat.length * mat[0].length * mat.length * mat[0].length)));
        }

        for (int i = 0; i < mat.length; i++) {
        	for (int j = 0; j < mat[0].length; j++) {
        		if (mat[i][j] == 0)
        			result[i][j] = 0;
        		if (i > 0)
        			result[i][j] = Math.min(result[i][j], result[i-1][j] + 1);
        		if (j > 0)
        			result[i][j] = Math.min(result[i][j], result[i][j-1] + 1);
        	}
        }
        
        for (int i = mat.length - 1; i >= 0; i--) {
        	for (int j = mat[0].length - 1; j >= 0; j--) {
        		if (mat[i][j] == 0)
        			result[i][j] = 0;
        		if (i < mat.length - 1)
        			result[i][j] = Math.min(result[i][j], result[i+1][j] + 1);
        		if (j < mat[0].length - 1)
        			result[i][j] = Math.min(result[i][j], result[i][j+1] + 1);
        	}
        }
        
        return result;
    }
}
