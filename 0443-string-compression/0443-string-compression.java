class Solution {
    public int compress(char[] chars) {
        //O(n) for expanding string
        String word = "";
        int length = chars.length;

        if(length == 1) {
            return 1;
        }

        char currChar = chars[0];
        int charCount = 1;

        //O(n) for n length of chars
        for(int i = 1; i < length; i++) {
            if(chars[i] == currChar) {
                charCount++;
            }
            else {
                word += currChar;
                if(charCount > 1) word += charCount;
                currChar = chars[i];
                charCount = 1;
            }
        }
        word += currChar;
        if(charCount > 1) word += charCount;
        
        for(int i = 0; i < word.length(); i++) {
            chars[i] = word.charAt(i);
        }

        return word.length();
    }
}