/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int L = 1;
        int R = n;
        int M;

        while(L < R) {
            M = L + (R - L) / 2;
            int pick = guess(M);
            if(pick == 0) {
                return M;
            }
            if(pick == 1) {
                L = M + 1;
            }
            else {
                R = M - 1;
            }
        }
        
        return L;
    }
}