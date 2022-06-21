package june;

public class JumpGameII {
	
    public int jump(int[] nums) {
    	
    	if (nums.length == 1)
    		return 0;
    		
    	int[] mj = new int[nums.length];
    	
    	for (int i = nums.length - 1; i >= 0; i--) {
    		if (i == nums.length - 1)
    			mj[i] = 0;
    		
    		int jumpDist = nums[i];
    		int tempMin = Integer.MAX_VALUE - 10000;
    		
    		if (jumpDist == 0) {
    			mj[i] = Integer.MAX_VALUE - 10000;
    			continue;
    		}
    		
    		if (i + jumpDist >= nums.length - 1) {
    			mj[i] = 1;
    		} else {
    			for (int j = 1; j <= jumpDist; j++) {
    				if (nums[i+j] == Integer.MAX_VALUE - 10000) {
    					continue;
    				}
    				int temp = 1 + mj[i+j];
    				if (temp < tempMin)
    					tempMin = temp;
    			}
    			mj[i] = tempMin;
    		}
    	}
    	
    	
    	return mj[0];
    }

}
