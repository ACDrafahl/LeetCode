class Solution {
    public String mergeAlternately(String word1, String word2) {
        int index1 = 0;
        int index2 = 0;
        String mergedString = "";
        while(index1 < word1.length() && index2 < word2.length()) {
            mergedString = mergedString + word1.charAt(index1);
            mergedString = mergedString + word2.charAt(index2);
            index1++;
            index2++;
        }
        if (index1 < word1.length()) {
            while (index1 < word1.length()) {
                mergedString = mergedString + word1.charAt(index1);
                index1++;
            }
        }
        if (index2 < word2.length()) {
            while (index2 < word2.length()) {
                mergedString = mergedString + word2.charAt(index2);
                index2++;
            }
        }
        return mergedString;
    }
}