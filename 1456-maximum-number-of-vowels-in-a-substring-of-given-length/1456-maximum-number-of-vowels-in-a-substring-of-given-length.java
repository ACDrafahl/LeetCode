class Solution {
    public int maxVowels(String s, int k) {
        //O(1) for all variables
        int length = s.length();
        int first = 0;
        int last = k - 1;
        int numVowels = 0;
        int maxVowels = 0;

        //check initial window
        //O(n) where n = k - 1
        for(int i = first; i <= last; i++) {
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i'
            || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                numVowels++;
            }
        }
        last++;
        maxVowels = numVowels;

        //O(n) where n is the length of s
        while (last < length) {
            char oldFirst = s.charAt(first);
            if(oldFirst == 'a' || oldFirst == 'e' || oldFirst == 'i'
            || oldFirst == 'o' || oldFirst == 'u') {
                numVowels--;
            }
            char newLast = s.charAt(last);
            if(newLast == 'a' || newLast == 'e' || newLast == 'i'
            || newLast == 'o' || newLast == 'u') {
                numVowels++;
            }
            first++;
            last++;
            maxVowels = Math.max(maxVowels, numVowels);
        }

        return maxVowels;
    }
}