class Solution {

    int totalWays(int n, int f, int target, HashMap<String, Integer> memo) {

        if (n == 0 && target == 0)
            return 1;

        if (n == 0 || target <= 0)
            return 0;

        String currentKey = n + "-" + target;

        if (memo.containsKey(currentKey))
            return memo.get(currentKey);

        int ways = 0;

        int MOD = 1000000007;
        int tempAns = 0;

        for (int i = 1; i <= f; i++) {
            tempAns = totalWays(n - 1, f, target - i, memo) % MOD;
            ways = ways % MOD;
            ways = (ways + tempAns) % MOD;
        }

        memo.put(currentKey, ways);
        return memo.get(currentKey);
    }

    public int numRollsToTarget(int n, int k, int target) {

        return totalWays(n, k, target, new HashMap<String, Integer>());
    }
}