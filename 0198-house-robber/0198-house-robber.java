class Solution {
    private int findMaxMoney(int[] nums, int currentHouse, HashMap<Integer, Integer> cache) {
        if (currentHouse >= nums.length)
            return 0;

        int currentKey = currentHouse;

        if (cache.containsKey(currentKey))
            return cache.get(currentKey);

        int rob = nums[currentHouse] + findMaxMoney(nums, currentHouse + 2, cache);
        int notRob = findMaxMoney(nums, currentHouse + 1, cache);

        cache.put(currentKey, Math.max(rob, notRob));
        return cache.get(currentKey);
    }

    public int rob(int[] nums) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        return Math.max(findMaxMoney(nums, 0, cache), findMaxMoney(nums, 1, cache));
    }
}