class Solution {
    private void generateSubsets(int currIdx, int[] nums, List<List<Integer>> ans, ArrayList<Integer> currentSubset) {
        if (currIdx >= nums.length) {
            ans.add(new ArrayList<Integer>(currentSubset));
            return;
        }

        currentSubset.add(nums[currIdx]);

        generateSubsets(currIdx + 1, nums, ans, currentSubset);

        currentSubset.remove(currentSubset.size() - 1);

        generateSubsets(currIdx + 1, nums, ans, currentSubset);
        return;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generateSubsets(0, nums, ans, new ArrayList<Integer>());
        return ans;
    }
}