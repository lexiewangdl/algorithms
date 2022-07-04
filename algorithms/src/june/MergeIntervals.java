package june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	
	public int[] mergeHelper(int[] a, int[] b) {
		int[] merge = new int[2];
		
		if (a[0] == b[0]) {
			merge[0] = b[0];
			merge[1] = Math.max(b[0], b[1]);
		} else if (a[1] >= b[0]) {
			merge[0] = a[0];
			merge[1] = Math.max(a[1], b[1]);
		} else {
			merge[0] = a[0];
			merge[1] = a[1];
		}
		
		return merge;
	}
	
    public int[][] merge(int[][] intervals) {
    	
    	if (intervals.length == 0) {
    		return new int[0][2];
    	}
    	
    	List<int[]> result = new ArrayList<int[]>();
    	
    	// Sort intervals based on start
    	Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    	
    	for (int i = 0; i < intervals.length; i++) {
    		if (result.size() == 0 || result.get(result.size() - 1)[1] < intervals[i][0]) {
    			result.add(new int[] {intervals[i][0], intervals[i][1]});
    		} else {
    			result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1], intervals[i][1]);
    		}
    	}
    	
    	return result.toArray(new int[result.size()][]);
    }

}
