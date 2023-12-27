class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int window = 0;
        int max = 0;

        //fills window
        for (int i = 0; i < k; i++) {
            window += nums[i];
        }
        max = window;

        int i = 0;
        while (i < nums.length - k) {
            window = window - nums[i] + nums[i + k];

            if(window > max) {
                max = window;
            }

            i++;
        }

        return (double)max / k;
    }
}