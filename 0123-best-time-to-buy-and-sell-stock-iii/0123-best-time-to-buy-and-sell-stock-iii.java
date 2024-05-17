class Solution {

    private int findMaxProfit(int[] prices, int currentDay, int canBuy, int transactionsAllowed,
            HashMap<String, Integer> memo) {

        if (currentDay == prices.length || transactionsAllowed == 0)
            return 0;

        String currentKey = currentDay + "-" + canBuy + "-" + transactionsAllowed;

        if (memo.containsKey(currentKey))
            return memo.get(currentKey);

        int idle = findMaxProfit(prices, currentDay + 1, canBuy, transactionsAllowed, memo);

        int buy = Integer.MIN_VALUE;
        int sell = Integer.MIN_VALUE;

        if (canBuy == 1) {
            buy = findMaxProfit(prices, currentDay + 1, 0, transactionsAllowed, memo) - prices[currentDay];
        } else
            sell = findMaxProfit(prices, currentDay + 1, 1, transactionsAllowed - 1, memo) + prices[currentDay];

        memo.put(currentKey, Math.max(idle, Math.max(buy, sell)));

        return memo.get(currentKey);
    }

    public int maxProfit(int[] prices) {
        return findMaxProfit(prices, 0, 1, 2, new HashMap<String, Integer>());
    }
}