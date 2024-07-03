class Solution {
    private boolean isPossible(int[] nums, int currentIdx, int targetSum, HashMap<String, Boolean> cache) {
        if (targetSum == 0) {
            return true;
        }

        if (currentIdx >= nums.length || targetSum < 0)
            return false;

        String currentKey = currentIdx + "-" + targetSum;

        if (cache.containsKey(currentKey))
            return cache.get(currentKey);

        boolean consider = false;

        if (nums[currentIdx] <= targetSum) {
            if(isPossible(nums, currentIdx + 1, targetSum - nums[currentIdx], cache))
                return true;
        }
        boolean notConsider = isPossible(nums, currentIdx + 1, targetSum, cache);

        cache.put(currentKey, consider || notConsider);

        return cache.get(currentKey);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0)
            return false;

        return isPossible(nums, 0, sum / 2, new HashMap<String, Boolean>());
    }
}