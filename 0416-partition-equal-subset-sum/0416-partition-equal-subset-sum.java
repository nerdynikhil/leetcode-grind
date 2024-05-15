class Solution {

    boolean find(int[] nums, int currIdx, int targetSum, HashMap<String, Boolean> memo) {
        if (targetSum == 0)
            return true;
        if (currIdx == nums.length || targetSum < 0)
            return false;

        String currentKey = Integer.toString(currIdx) + "-" + Integer.toString(targetSum);

        if (memo.containsKey(currentKey)) {
            return memo.get(currentKey);
        }

        boolean consider = false;

        if (nums[currIdx] <= targetSum) {
            if(find(nums, currIdx + 1, targetSum - nums[currIdx], memo))
                return true;
        }

        boolean notConsider = find(nums, currIdx + 1, targetSum, memo);

        memo.put(currentKey, consider || notConsider);

        return memo.get(currentKey);
    }

    public boolean canPartition(int[] nums) {
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0)
            return false;

        return find(nums, 0, totalSum / 2, new HashMap<String, Boolean>());
    }
}