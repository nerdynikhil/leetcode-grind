class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = findFirstPos(nums, target);
        ans[1] = findLastPos(nums, target);
        return ans;
    }

    private int findFirstPos(int[] nums, int target){
        int high = nums.length-1;
        int low = 0;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target){
                high = mid-1;
                ans = mid;
            }
            else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private int findLastPos(int[] nums, int target){
        int high = nums.length-1;
        int low = 0;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target){
                low = mid+1;
                ans = mid;
            }   
            else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}