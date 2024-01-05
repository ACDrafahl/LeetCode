class Solution {
    public String reverseWords(String s) {
        //O(1) for array
        String[] words = s.split("\\s+");
        String answer = "";

        //O(n) for n words in array
        for(int i = words.length - 1; i >= 0; i--) {
            answer += words[i] + " ";
        }

        return answer.trim();
    }
}