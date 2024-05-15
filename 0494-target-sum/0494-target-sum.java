class Solution {

    int totalWays(int[] nums, int currIdx, int target) {
        if (currIdx == nums.length && target == 0)
            return 1;

        if (currIdx == nums.length && target != 0)
            return 0;

        int plus = totalWays(nums, currIdx + 1, target - nums[currIdx]);
        int minus = totalWays(nums, currIdx + 1, target + nums[currIdx]);

        return plus + minus;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return totalWays(nums, 0, target);
    }
}