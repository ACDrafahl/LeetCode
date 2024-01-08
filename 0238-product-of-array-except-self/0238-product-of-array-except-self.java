class Solution {
    public int[] productExceptSelf(int[] nums) {
        int initial = 0;
        int length = nums.length;
        int[] results = new int[length];
        int zeroCount = 0;

        for(int i = 0; i < length; i++) {
            if(nums[i] == 0) {
                zeroCount++;
            }
            else {
                if(initial == 0) {
                    initial = nums[i];
                }
                else {
                    initial = initial * nums[i];
                }
            }
        }

        if(zeroCount == 1) {
            for(int i = 0; i < length; i++) {
                if(nums[i] == 0) {
                    results[i] = initial;
                }
                else {
                    results[i] = 0;
                }
            }
        }
        else if(zeroCount > 1) {
            for(int i = 0; i < length; i++) {
                results[i] = 0;
            }   
        }
        else {
            for(int i = 0; i < length; i++) {
                results[i] = initial / nums[i];
            }   
        }
        

        return results;
        
    }
}