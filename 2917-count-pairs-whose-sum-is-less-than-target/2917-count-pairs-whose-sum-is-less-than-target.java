class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        int count = 0;

        Collections.sort(nums);

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum < target) {
                count += right - left;
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}