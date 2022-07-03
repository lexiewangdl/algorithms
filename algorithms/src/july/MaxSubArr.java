package july;

public class MaxSubArr {
	
	// Sliding Window
	
    public int maxSubArray(int[] nums) {
    	
    	int prefixSum = 0;
    	int result = nums[0];
    	
    	for (int n : nums) {
    		prefixSum = Math.max(prefixSum + n, n);
    		result = Math.max(result, prefixSum);
    	}
    	
    	return result;
    }
    
    // Divide and Conquer
    
    public class Values {
    	public int lSum, rSum, mSum, iSum;
    	
    	public Values(int lSum, int rSum, int mSum, int iSum) {
    		this.lSum = lSum;
    		this.rSum = rSum;
    		this.mSum = mSum;
    		this.iSum = iSum;
    	}
    }
    
    public Values pushUp(Values l, Values r) {
    	int iSum = l.iSum + r.iSum;
    	int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        
        return new Values(lSum, rSum, mSum, iSum);
    }
    
    public Values get(int[] arr, int l, int r) {
    	if (l == r) {
    		return new Values(arr[l], arr[l], arr[l], arr[l]);
    	}
    	int m = (l + r)>>1;
    	Values lSub = get(arr, l, m);
    	Values rSub = get(arr, m+1, r);
    	
    	return pushUp(lSub, rSub);
    }
    
    public int msa(int[] nums) {
    	return 1;
    }
}
