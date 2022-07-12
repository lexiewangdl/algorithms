package july;

public class SortColors {
	
	public void swap(int[] nums, int i, int t) {
		int temp = nums[t];
		nums[t] = nums[i];
		nums[i] = temp;
	}
	
    public void sortColors(int[] nums) {

    	int lr = -1;
    	int fb = nums.length;	

    	for (int i = 0; i < fb;) {
    		if (nums[i] == 1) {
    			i++;
    		}
    		else if (nums[i] == 0) {
    			swap(nums, i++, ++lr);
    		} 
    		else if (nums[i] == 2) {
    			swap(nums, i, --fb);
    		}
    	}
    }

}
