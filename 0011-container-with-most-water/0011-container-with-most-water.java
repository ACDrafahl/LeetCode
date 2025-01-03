class Solution {
    public int maxArea(int[] height) {
        // O(1) space for variable declarations
        int i = 0;
        int j = height.length - 1;
        int maxWater = 0;
        int currWater = 0;

        // O(n) time for while loop
        while (i < j) {
            currWater = (j - i) * (Math.min(height[i], height[j]));
            if (currWater > maxWater) {
                maxWater = currWater;
            }

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxWater;
    }
}