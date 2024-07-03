class Solution {
    private int findMinCost(int[] cost, int currentIndex, HashMap<Integer, Integer> cache) {
        if (currentIndex == cost.length)
            return 0;
        if (currentIndex > cost.length)
            return 1000;

        int currentKey = currentIndex;

        if (cache.containsKey(currentKey))
            return cache.get(currentKey);

        int oneJump = cost[currentIndex] + findMinCost(cost, currentIndex + 1, cache);
        int twoJumps = cost[currentIndex] + findMinCost(cost, currentIndex + 2, cache);

        cache.put(currentKey, Math.min(oneJump, twoJumps));

        return cache.get(currentKey);
    }

    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        return Math.min(findMinCost(cost, 0, cache), findMinCost(cost, 1, cache));
    }
}