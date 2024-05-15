class Solution {

    int totalWays(int[] nums, int currIdx, int target, HashMap<String, Integer> memo) {
        if (currIdx == nums.length && target == 0)
            return 1;

        if (currIdx == nums.length && target != 0)
            return 0;

        String currentKey = Integer.toString(currIdx) + "-" + Integer.toString(target);

        if (memo.containsKey(currentKey))
            return memo.get(currentKey);

        int plus = totalWays(nums, currIdx + 1, target - nums[currIdx], memo);
        int minus = totalWays(nums, currIdx + 1, target + nums[currIdx], memo);

        memo.put(currentKey, plus + minus);

        return memo.get(currentKey);
    }

    public int findTargetSumWays(int[] nums, int target) {
        return totalWays(nums, 0, target, new HashMap<String, Integer>());
    }
}