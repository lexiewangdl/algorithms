package july;

public class UniquePaths {
	
	// Dynamic Programming
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        // 对于第一行dp[0][j]，或者第一列dp[i][0]，由于都是在边界，所以只能为1
        for (int i = 0; i < m; i++) {
        	dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
        	dp[0][i] = 1;
        }
        
        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		// 在每一格的路径可能性都是由其左侧或上方格子决定的
        		dp[i][j] = dp[i-1][j] + dp[i][j-1]; // 动态方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
        	}
        }

        return dp[m-1][n-1];
    }

}
