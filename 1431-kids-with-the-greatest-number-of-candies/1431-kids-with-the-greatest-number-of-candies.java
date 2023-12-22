class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int candyMax = 0;
        ArrayList<Boolean> greatest = new ArrayList<>();

        for(int i = 0; i < candies.length; i++) {
            if(candies[i] > candyMax) {
                candyMax = candies[i];
            }
        }
        
        System.out.println(candyMax);
        for(int i = 0; i < candies.length; i++) {
            if(candies[i] + extraCandies >= candyMax) 
                greatest.add(true);
            else
                greatest.add(false);
        }

        return greatest;
    }
}