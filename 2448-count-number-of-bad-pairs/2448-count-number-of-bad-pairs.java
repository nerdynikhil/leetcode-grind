class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Long> freqMap = new HashMap<>();
        long goodPairs = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int diff = nums[i] - i;
            goodPairs += freqMap.getOrDefault(diff, 0L);
            freqMap.put(diff, freqMap.getOrDefault(diff, 0L) + 1);
        }

        long totalPairs = (long) n * (n - 1) / 2;
        return totalPairs - goodPairs;
    }
}