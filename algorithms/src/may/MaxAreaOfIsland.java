package may;

// 695. Max Area of Island
public class MaxAreaOfIsland {

	// Returns area of current island
	public static int area(int[][] grid, boolean[][] seen, int r, int c) {
		// If index out of range, return 0
		if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
			return 0;

		// If current pixel was checked or if current pixel is water, return 0
		if (seen[r][c] || grid[r][c] == 0)
			return 0;

		seen[r][c] = true; // This pixel is now checked
		// Move 4-directionally to find the total area of island
		int a = 1 + 
				area(grid, seen, r - 1, c) + 
				area(grid, seen, r + 1, c) + 
				area(grid, seen, r, c - 1) + 
				area(grid, seen, r, c + 1);

		return a;
	}

	public int maxAreaOfIsland(int[][] grid) {
		boolean[][] seen = new boolean[grid.length][grid[0].length];
		int maxArea = 0;
		
		int i = 0, j = 0;
		while (i < grid.length) {
			j = 0;
			while (j < grid.length) {
				int area = area(grid, seen, i, j);
				maxArea = (area > maxArea) ? area : maxArea;
				j++;
			}
			i++;
		}

//		for (int i = 0; i < grid.length; i++) {
//			for (int j = 0; j < grid[0].length; j++) {
//				int area = area(grid, seen, i, j);
//				maxArea = (area > maxArea) ? area : maxArea;
//			}
//		}
		
		return maxArea;
	}
}
