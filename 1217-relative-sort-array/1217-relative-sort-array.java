class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int el : arr1) {
            freq.put(el, freq.getOrDefault(el, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();

        for (int el : arr2) {
            while (freq.getOrDefault(el, 0) > 0) {
                ans.add(el);
                freq.put(el, freq.get(el) - 1);
            }
        }

        List<Integer> remaining = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int el = entry.getKey();
            int count = entry.getValue();
            while (count > 0) {
                remaining.add(el);
                count--;
            }
        }

        Collections.sort(remaining);

        ans.addAll(remaining);

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}