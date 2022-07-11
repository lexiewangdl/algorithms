package july;

import java.util.ArrayDeque;

public class SetMatrixZeroes {
	
    public void setZeroes(int[][] matrix) {
        ArrayDeque<int[]> zeroCoords = new ArrayDeque<>();
        
        int n = matrix.length, m = matrix[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0)
                    zeroCoords.add(new int[]{i, j});
            }
        }
        
        while (!zeroCoords.isEmpty()) {
            int[] current = zeroCoords.pop();
            for (int i = 0; i < n; i++) {
                matrix[i][current[1]] = 0;
            }
            for (int i = 0; i < m; i++) {
                matrix[current[0]][i] = 0;
            }
        }
        
    }

}
