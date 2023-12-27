class Solution {
    public boolean isSubsequence(String s, String t) {
        int sPointer = 0;
        int tLength = t.length();
        int sLength = s.length();

        if (tLength == 0 && sLength == 0) {
            return true;
        }
        else if (tLength == 0) {
            return false;
        }
        else if (sLength == 0) {
            return true;
        }
    
        for (int i = 0; i < tLength; i++) {
            if (t.charAt(i) == s.charAt(sPointer)) {
                sPointer++;
            }
            if (sPointer == sLength) {
            return true;
            }
        }

        return false;

    }
}

