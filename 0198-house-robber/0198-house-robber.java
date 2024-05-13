class Solution {
    int maxMoney(int[] nums, int currentHouse, HashMap<Integer, Integer> memo) {
        if (currentHouse >= nums.length)
            return 0;

        int currentKey = currentHouse;

        if (memo.containsKey(currentKey))
            return memo.get(currentKey);

        int rob = nums[currentHouse] + maxMoney(nums, currentHouse + 2, memo);
        int notRob = maxMoney(nums, currentHouse + 1, memo);

        memo.put(currentKey, Math.max(rob, notRob));
        return Math.max(rob, notRob);
    }

    public int rob(int[] nums) {
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
        return maxMoney(nums, 0, memo);
    }
}