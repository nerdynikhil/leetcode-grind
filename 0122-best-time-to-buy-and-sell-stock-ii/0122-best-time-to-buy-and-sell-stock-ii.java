class Solution {

    private int findMaxProfit(int[] prices, int currentDay, int canBuy, HashMap<String, Integer> memo) {

        if (currentDay == prices.length)
            return 0;

        String currentKey = currentDay + "-" + canBuy;

        if (memo.containsKey(currentKey))
            return memo.get(currentKey);

        int idle = findMaxProfit(prices, currentDay + 1, canBuy, memo);

        int buy = Integer.MIN_VALUE;
        int sell = Integer.MIN_VALUE;

        if (canBuy == 1) {
            buy = findMaxProfit(prices, currentDay + 1, 0, memo) - prices[currentDay];
        } else
            sell = findMaxProfit(prices, currentDay + 1, 1, memo) + prices[currentDay];

        memo.put(currentKey, Math.max(idle, Math.max(buy, sell)));

        return memo.get(currentKey);
    }

    public int maxProfit(int[] prices) {
        return findMaxProfit(prices, 0, 1, new HashMap<String, Integer>());
    }
}