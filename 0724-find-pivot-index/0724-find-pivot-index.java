class Solution {
    public int pivotIndex(int[] nums) {
        int length = nums.length;
        int beforeSum = 0;
        int afterSum = 0;

        if (length == 1) {
            return 0;
        }

        //O(n) where n is length of nums - 1
        for (int i = 1; i < length; i++) {
            afterSum += nums[i];
        }
        if (afterSum == 0) {
            return 0;
        }

        for (int pivot = 1; pivot < length; pivot++) {
            beforeSum += nums[pivot - 1];
            afterSum -= nums[pivot];
            if (beforeSum == afterSum) {
                return pivot;
            }
        }

        return -1;
        
    }
}