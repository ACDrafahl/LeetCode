class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int numPlantable = 0;
        int len = flowerbed.length;

        //n = 0 case
        if(n == 0) {
            return true;
        }

        if (len > 1) {
            // Funny edgecases hehe
            if (flowerbed[0] == 0 && flowerbed[0 + 1] == 0) {
                flowerbed[0] = 1;
                numPlantable++;
            }
            if (flowerbed[len - 1] == 0 && flowerbed[len - 2] == 0) {
                flowerbed[len - 1] = 1;
                numPlantable++;
            }

            // Everything else
            for (int i = 1; i < len - 1; i++) {
                if (flowerbed[i] != 1 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    numPlantable++;
                }
            }
        }
        // Singular flowerbed, either case
        else if (flowerbed[0] == 0) {
            numPlantable = 1;
        }
        else {
            return false;
        }


        if (n > numPlantable) {
            return false;
        }
        return true;
    }
}