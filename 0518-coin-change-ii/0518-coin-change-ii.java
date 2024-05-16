class Solution {

    int totalWays(int amount, int[] coins, int currentIndex, HashMap<String, Integer> memo) {
        if (amount == 0)
            return 1;

        if (currentIndex >= coins.length)
            return 0;

        String currentKey = currentIndex + "-" + amount;

        if (memo.containsKey(currentKey))
            return memo.get(currentKey);

        int consider = 0;

        if (amount >= coins[currentIndex])
            consider = totalWays(amount - coins[currentIndex], coins, currentIndex, memo);

        int notConsider = totalWays(amount, coins, currentIndex + 1, memo);

        memo.put(currentKey, consider + notConsider);

        return memo.get(currentKey);
    }

    public int change(int amount, int[] coins) {
        return totalWays(amount, coins, 0, new HashMap<String, Integer>());
    }
}