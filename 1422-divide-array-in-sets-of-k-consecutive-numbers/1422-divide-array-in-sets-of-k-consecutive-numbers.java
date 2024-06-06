class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }

        Arrays.sort(nums);

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (freqMap.get(num) == 0) {
                continue;
            }

            for (int i = 0; i < k; i++) {
                int current = num + i;
                if (freqMap.getOrDefault(current, 0) <= 0) {
                    return false;
                }
                freqMap.put(current, freqMap.get(current) - 1);
            }
        }

        return true;
    }
}