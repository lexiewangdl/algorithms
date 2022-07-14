package july;

public class WordSearch {
	
	public boolean check(char[][] board, boolean[][] checked, 
							int i, int j, String word, int k) {
		if (board[i][j] != word.charAt(k)) {
			return false;
		} 
		// if the k-th char in word is same as board[i][j]
		// and the k-th char is the last char in word
		else if (k == word.length() - 1) {
			return true;
		}
		checked[i][j] = true; // checked this cell
		
		int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
		boolean result = false;
		
		for (int[] d : directions) { // In 4 directions:
			
			// i and j index of one adjacent cell
			int newi = i + d[0], newj = j + d[1];
			
			// If this is a valid adjacent cell
			if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
				if (!checked[newi][newj]) {
					// Check this adjacent cell:
					// Whether it matches the (k+1)-th char in word
					boolean f = check(board, checked, newi, newj, word, k+1);
					if (f) { // matches
						result = true;
						break;
					}
				}
			}
		}
		
		checked[i][j] = false;
		return result;
	}
	
    public boolean exist(char[][] board, String word) {
    	int a = board.length, b = board[0].length;
    	boolean[][] checked = new boolean[a][b]; // Used to keep track of where we've been
    	
    	for (int i = 0; i < a; i++) {
    		for (int j = 0; j < b; j++) {
    			boolean f = check(board, checked, i, j, word, 0);
    			if (f)
    				return true;
    		}
    	}
    	
    	return true;
    }

}
