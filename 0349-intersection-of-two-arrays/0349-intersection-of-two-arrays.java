class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();

        for (int num : nums1) {
            if (counts.containsKey(num))
                counts.put(num, counts.get(num) + 1);
            else
                counts.put(num, 1);
        }

        HashSet<Integer> res = new HashSet();
        for (int num : nums2) {
            if (counts.containsKey(num)) {
                res.add(num);
            }
        }

        int[] result = res.stream().mapToInt(Integer::intValue).toArray();

        return result;
    }
}