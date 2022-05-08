package may;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 994. Rotting Oranges 
// https://leetcode.com/problems/rotting-oranges/

public class RottingOranges {

	// If seen
	static boolean[][] seen;

	// Direction vectors, used to find 4 adjacent cells of target cell
	static int dirRow[] = { -1, 0, 1, 0 };
	static int dirCol[] = { 0, 1, 0, -1 };

	public boolean isValidOrange(int rIdx, int cIdx, int[][] grid) {
		if (rIdx < 0 || rIdx >= grid.length)
			return false;
		if (cIdx < 0 || cIdx >= grid[0].length)
			return false;
		if (grid[rIdx][cIdx] == 1)
			return true;
		else
			return false;
	}

	// Pair of row and column indices to store in queue
	public class Indices {
		int time;
		int rowIdx;
		int columnIdx;

		public Indices(int t, int ridx, int cidx) {
			this.time = t;
			this.rowIdx = ridx;
			this.columnIdx = cidx;
		}
	}

	public int orangesRotting(int[][] grid) {
		seen = new boolean[grid.length][grid[0].length];
		Queue<Indices> q = new LinkedList<>();
		int time = 0;

		// Find the rotten oranges first, and add them to queue
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2)
					q.add(new Indices(0, i, j)); // Queue currently stores rotten oranges at time 0
			}
		}

		while (!q.isEmpty()) {
			Indices temp = q.poll();

			for (int i = 0; i < 4; i++) {
				// Adjacent oranges, 4-directionally
				int adjR = temp.rowIdx + dirRow[i];
				int adjC = temp.columnIdx + dirCol[i];

				if (isValidOrange(adjR, adjC, grid)) {
					if (!seen[adjR][adjC]) {
						q.add(new Indices(temp.time + 1, adjR, adjC));
						time = temp.time + 1;
						seen[adjR][adjC] = true;
						grid[adjR][adjC] = 2;
					}
				}
			}
		}

		for (int i[] : grid) {
			for (int j : i)
				if (j == 1)
					return -1;
		}

		return time;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RottingOranges ro = new RottingOranges();

		int m = sc.nextInt();
		int n = sc.nextInt();
		int grid[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		System.out.println(ro.orangesRotting(grid));
	}

}
