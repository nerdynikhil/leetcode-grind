class Solution {
    private int findTribonacci(int n, HashMap<Integer, Integer> cache) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;

        int currentKey = n;

        if (cache.containsKey(currentKey)) {
            return cache.get(currentKey);
        }

        cache.put(currentKey,
                findTribonacci(n - 1, cache) + findTribonacci(n - 2, cache) + findTribonacci(n - 3, cache));
        return cache.get(currentKey);
    }

    public int tribonacci(int n) {
        return findTribonacci(n, new HashMap<Integer, Integer>());
    }
}