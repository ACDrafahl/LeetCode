class Solution {
    public String mergeAlternately(String word1, String word2) {
        int index = 0;

        String mergedString = "";
        while(index < word1.length() && index < word2.length()) {
            mergedString = mergedString + word1.charAt(index);
            mergedString = mergedString + word2.charAt(index);
            index++;
        }
        if (index < word1.length()) {
            while (index < word1.length()) {
                mergedString = mergedString + word1.charAt(index);
                index++;
            }
        }
        if (index < word2.length()) {
            while (index < word2.length()) {
                mergedString = mergedString + word2.charAt(index);
                index++;
            }
        }
        return mergedString;
    }
}