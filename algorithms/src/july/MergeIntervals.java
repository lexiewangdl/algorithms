package july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	
	public int[] mergeHelper(int[] a, int[] b) {
		
		if (a[1] < b[0]) {
			return new int[] {b[0], b[1]};
		} else {
			a[1] = Math.max(a[1], b[1]);
		}
		
		return a;
	}
	
    public int[][] merge(int[][] intervals) {
    	
    	if (intervals.length == 0) {
    		return new int[0][2];
    	}
    	
    	List<int[]> result = new ArrayList<int[]>();
    	
    	// Sort intervals based on start
    	Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    	
    	for (int i = 0; i < intervals.length; i++) {
    		if (result.size() == 0) {
    			result.add(new int[] {intervals[i][0], intervals[i][1]});
    			continue;
    		}

    		
    		if (result.get(result.size() - 1)[1] < intervals[i][0]) {
    			result.add(new int[] {intervals[i][0], intervals[i][1]});
    		} else {
    			result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1], intervals[i][1]);
    		}
    	}
    	
    	return result.toArray(new int[result.size()][]);
    }

}
