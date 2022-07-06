package july;

public class UniquePaths {
	
	// Dynamic Programming
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        // ���ڵ�һ��dp[0][j]�����ߵ�һ��dp[i][0]�����ڶ����ڱ߽磬����ֻ��Ϊ1
        for (int i = 0; i < m; i++) {
        	dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
        	dp[0][i] = 1;
        }
        
        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		// ��ÿһ���·�������Զ������������Ϸ����Ӿ�����
        		dp[i][j] = dp[i-1][j] + dp[i][j-1]; // ��̬���̣�dp[i][j] = dp[i-1][j] + dp[i][j-1]
        	}
        }

        return dp[m-1][n-1];
    }

}
