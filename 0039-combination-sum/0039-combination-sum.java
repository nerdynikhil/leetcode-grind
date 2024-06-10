class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        generateCombs(candidates, 0, target, new ArrayList<Integer>(), ans);
        return ans;
    }

    private void generateCombs(int[] nums, int currIdx, int target, ArrayList<Integer> current,
            List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        if (currIdx == nums.length) {
            return;
        }

        if (nums[currIdx] <= target) {
            current.add(nums[currIdx]);
            generateCombs(nums, currIdx, target - nums[currIdx], current, ans);
            current.remove(current.size() - 1);
        }
        generateCombs(nums, currIdx + 1, target, current, ans);

    }
}