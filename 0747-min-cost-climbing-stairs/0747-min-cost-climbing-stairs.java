class Solution {

    int minCost(int[] cost, int currentStep, HashMap<Integer, Integer> memo) {

        if (currentStep == cost.length)
            return 0;

        if (currentStep > cost.length)
            return 1000;

        int currentKey = currentStep;

        if (memo.containsKey(currentKey)) {
            return memo.get(currentKey);
        }

        int oneJump = cost[currentStep] + minCost(cost, currentStep + 1, memo);
        int twoJumps = cost[currentStep] + minCost(cost, currentStep + 2, memo);

        memo.put(currentKey, Math.min(oneJump, twoJumps));

        return memo.get(currentKey);
    }

    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
        return Math.min(minCost(cost, 0, memo), minCost(cost, 1, memo));
    }
}