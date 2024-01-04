class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length - 1;
        int[] cheapest = new int[n + 1]; //+ 1 t compensate for n = 0
        cheapest[0] = cost[0];
        cheapest[1] = cost[1];

        for(int i = 2; i <= n; i++) {
            cheapest[i] = cost[i] + Math.min(cheapest[i - 1], cheapest[i - 2]);
        }

        return Math.min(cheapest[n], cheapest[n - 1]);
    }
}