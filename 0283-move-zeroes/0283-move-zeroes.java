class Solution {
    public void moveZeroes(int[] nums) {
        int pointer1 = 0;
        int swap = 0;
        for(int pointer2 = 1; pointer2 < nums.length;) {
            if(nums[pointer1] != 0) { //if P1 isn't 0
                pointer1++;
                pointer2++;
            }
            else if(nums[pointer2] != 0) { //if P1 is 0 and P2 isn't 0
                swap = nums[pointer1];
                nums[pointer1] = nums[pointer2];
                nums[pointer2] = swap;
                pointer1++;
                pointer2++;
            }
            else { //if P1 is 0 and P2 is 0
                pointer2++;
            }
        }
    }
}