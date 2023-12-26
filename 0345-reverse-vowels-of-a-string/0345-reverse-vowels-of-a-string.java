class Solution {
    public String reverseVowels(String s) {
        StringBuilder reversed = new StringBuilder(s);
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        ArrayList<Integer> vowelIndices = new ArrayList<>();
        boolean hasVowels = false;
        char swapChar;

        for(int i = 0; i < s.length(); i++) {
            if(vowels.contains(s.charAt(i))) {
                hasVowels = true; //should be a way to avoid so many reassignments here
                vowelIndices.add(i);
            }
        }

        if(!hasVowels) {
            return s;
        }

        int last = vowelIndices.size() - 1;
        for(int first = 0; first <= last; first++) {
            swapChar = reversed.charAt(vowelIndices.get(first));
            reversed.setCharAt(vowelIndices.get(first), reversed.charAt(vowelIndices.get(last)));
            reversed.setCharAt(vowelIndices.get(last), swapChar);
            last--;
        }

        return reversed.toString();
    }
}