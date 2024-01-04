class Solution {
    public int tribonacci(int n) {
        //recursive approach, not preferred, time limit exceeded
        /*
        if (n <= 1) { //base case
            return n;
        }
        if(n == 2) {
            return 1;
        }
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        */

        //dynamic approach, more efficient
        int[] DP = new int[n + 3]; // + 2 to handle n = 0

        DP[0] = 0;
        DP[1] = 1;
        DP[2] = 1;

        for(int i = 3; i <= n; i++) {
            DP[i] = DP[i - 1] + DP[i - 2] + DP[i -3];
        }

        return DP[n];
    }
}