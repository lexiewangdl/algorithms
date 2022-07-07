package july;

public class UniquePathsII {
	
	// ִ����ʱ��0ms��������Java�ύ�л�����100%���û�
	// �ڴ����ģ�39.7MB��������Java�ύ�л�����30.28%���û�
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	
    	int nrows = obstacleGrid.length;
    	int ncols = obstacleGrid[0].length;

    	int[][] dp = new int[nrows][ncols];
    	
    	boolean obs = false;
    	for (int i = 0; i < nrows; i++) {
    		if (obstacleGrid[i][0] == 1) {
    			obs = true;
    		}
    		dp[i][0] = (obs) ? 0 : 1;
    	}
    	
    	obs = false;
    	for (int i = 0; i < ncols; i++) {
    		if (obstacleGrid[0][i] == 1) {
    			obs = true;
    		}
    		dp[0][i] = (obs) ? 0 : 1;
    	}
    	
    	for (int i = 1; i < nrows; i++) {
    		for (int j = 1; j < ncols; j++) {
    			if (obstacleGrid[i][j] == 1) {
    				dp[i][j] = 0;
    			} else {
    				dp[i][j] = dp[i][j-1] + dp[i-1][j]; // ��̬����
    			}
    		}
    	}
    	
    	return dp[nrows-1][ncols-1];
    }

}
