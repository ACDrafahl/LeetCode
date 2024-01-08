class Solution {
    public int[] productExceptSelf(int[] nums) {
        //O(n) for int[n]
        int initial = 0;
        int length = nums.length;
        int[] results = new int[length];
        int zeroCount = 0;

        //O(n) for n elements in nums
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

        //O(n) for n elements in nums
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