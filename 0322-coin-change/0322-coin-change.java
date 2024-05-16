class Solution {

    int minCoins(int amount, int[] coins, int currentIndex, HashMap<String, Integer> memo) {
        if (amount == 0)
            return 0;

        if (currentIndex == coins.length)
            return 10001;

        String currentKey = amount + "-" + currentIndex;

        if (memo.containsKey(currentKey))
            return memo.get(currentKey);

        int consider = 10001;

        int currentCoin = coins[currentIndex];

        if (currentCoin <= amount)
            consider = 1 + minCoins(amount - currentCoin, coins, currentIndex, memo);

        int notConsider = minCoins(amount, coins, currentIndex + 1, memo);

        memo.put(currentKey, Math.min(consider, notConsider));

        return memo.get(currentKey);
    }

    public int coinChange(int[] coins, int amount) {
        int ans = minCoins(amount, coins, 0, new HashMap<String, Integer>());

        if (ans == 10001)
            return -1;

        return ans;
    }
}