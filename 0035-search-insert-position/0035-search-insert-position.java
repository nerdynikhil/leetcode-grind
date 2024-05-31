class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        int correctPos = nums.length;

        while (low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                correctPos = mid;
                high = mid - 1;
            }
        }
        return correctPos;
    }
}