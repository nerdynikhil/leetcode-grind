class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<Integer> ans = new ArrayList<>();

        int firstPos = findFirstPos(nums, target);
        if (firstPos == -1)
            return ans;
        int lastPos = findLastPos(nums, target);

        for (int i = firstPos; i <= lastPos; i++) {
            ans.add(i);
        }
        return ans;

    }

    private int findFirstPos(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                high = mid - 1;
                ans = mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private int findLastPos(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                low = mid + 1;
                ans = mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}