class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {

        int totalBottles = numBottles; // 9

        while (numBottles >= numExchange){ // 3 == 3

            int r = numBottles % numExchange;
            numBottles = numBottles / numExchange; // 3/3
          
            totalBottles = totalBottles + numBottles; // 9+3 12

            numBottles =  numBottles + r; // 3 + 3%3 = 3 + 0= 3
        }

        return totalBottles;
    }
}