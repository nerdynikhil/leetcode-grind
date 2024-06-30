class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        PriorityQueue<int[]> maxPq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // max-heap
        PriorityQueue<int[]> minPq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // min-heap
        int i = 0;
        int j = 0;
        int maxLength = 0;

        while (j < n) {
            maxPq.add(new int[] { nums[j], j });
            minPq.add(new int[] { nums[j], j });

            while (maxPq.peek()[0] - minPq.peek()[0] > limit) {
                i = Math.min(maxPq.peek()[1], minPq.peek()[1]) + 1;
                while (maxPq.peek()[1] < i) {
                    maxPq.poll();
                }
                while (minPq.peek()[1] < i) {
                    minPq.poll();
                }
            }

            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }

        return maxLength;
    }
}