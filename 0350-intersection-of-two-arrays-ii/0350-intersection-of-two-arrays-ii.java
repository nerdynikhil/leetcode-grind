class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        List<Integer> intersection = new ArrayList<>();

        for (int num : nums1) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            if (mp.getOrDefault(num, 0) > 0) {
                intersection.add(num);
                mp.put(num, mp.get(num) - 1);
            }
        }

        int[] result = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }

        return result;
    }
}