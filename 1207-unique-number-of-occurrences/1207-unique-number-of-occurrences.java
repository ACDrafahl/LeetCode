class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> occurences = new HashMap<>();

        //O(n) for n elements in array
        for (int i : arr) {
            //if the occurence is new, set its number of occurences to 0
            //O(1) for putIfAbsent
            occurences.putIfAbsent(i, 0);
            //increase number of occurences
            //O(1) for put
            occurences.put(i, occurences.get(i) + 1);
        }

        //O(n) for HashSet, O(n) for values()
        Set<Integer> uniqueValues = new HashSet<>(occurences.values());

        //O(n) for values()
        return uniqueValues.size() == occurences.values().size();
    }
}