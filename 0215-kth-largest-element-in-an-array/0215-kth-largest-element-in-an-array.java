class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);

        for (int num : nums) {
            maxHeap.add(num);
        }

        int ans = 0;

        while (k-- > 0) {
            ans = maxHeap.poll();
        }

        return ans;
    }
}