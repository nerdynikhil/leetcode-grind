class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int longest = 1;
        int increasing = 1;
        int decreasing = 1;

        for (int i = 1; i < n; ++i) {
            if (nums[i] > nums[i - 1])
                increasing++;
            else
                increasing = 1;

            if (nums[i] < nums[i - 1])
                decreasing++;
            else
                decreasing = 1;

            longest = Math.max(Math.max(longest, increasing), decreasing);
        }
        return longest;
    }
}