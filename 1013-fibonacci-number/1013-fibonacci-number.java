class Solution {
    private int findFib(int n, HashMap<Integer, Integer> mp) {
        if (n == 0 || n == 1)
            return n;

        int currentKey = n;

        if (mp.containsKey(currentKey))
            return mp.get(currentKey);

        int a = findFib(n - 1, mp);
        int b = findFib(n - 2, mp);

        mp.put(currentKey, a + b);
        return mp.get(currentKey);
    }

    public int fib(int n) {
        return findFib(n, new HashMap<Integer, Integer>());
    }
}