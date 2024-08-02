class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int ones = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1)
                ones++;
        }

        if (ones == 0)
            return 0;

        int a[] = new int[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            a[i] = nums[i % n];
        }

        int maxOnesInWindow = 0;
        int currentOnes = 0;

        for (int i = 0; i < 2 * n; i++) {
            if (i >= ones && a[i - ones] == 1)
                currentOnes--;
            if (a[i] == 1)
                currentOnes++;
            if (i >= ones - 1) {
                maxOnesInWindow = Math.max(maxOnesInWindow, currentOnes);
            }
        }
        return ones - maxOnesInWindow;
    }
}