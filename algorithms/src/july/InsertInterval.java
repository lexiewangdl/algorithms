package july;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	// 执行用时：1ms，在所有Java提交中击败了86.12%的用户
	
	public void mergeHelper(List<int[]> result, int[] interval) {
		if (result.size() == 0) {
			result.add(interval);
			return;
		}
		if (result.get(result.size() - 1)[1] < interval[0]) {
			result.add(interval);
		} else {
			result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], interval[1]);
		}
	}

	public int[][] insert(int[][] intervals, int[] newInterval) {
		
		List<int[]> result = new ArrayList<int[]>();
		
		if (intervals.length == 0) {
			mergeHelper(result, newInterval);
			return result.toArray(new int[result.size()][]);
		}

		int p = 0;
		for (int i = 0; i < intervals.length; i++) {
			if (intervals[i][0] > newInterval[0]) {
				p = i;
				break;
			} else {
				result.add(intervals[i]);
			}
		}
		
		mergeHelper(result, newInterval);
		
		for (int i = p; i < intervals.length; i++) {
			mergeHelper(result, intervals[i]);
		}

		return result.toArray(new int[result.size()][]);
	}
}
