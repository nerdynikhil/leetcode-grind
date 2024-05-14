class Solution {
    int findTrib(int n, HashMap<Integer, Integer> memo) {
        if (n == 0)
            return 0;

        if (n == 1 || n == 2)
            return 1;

        int currentKey = n;

        if (memo.containsKey(currentKey))
            return memo.get(currentKey);

        int a = findTrib(n - 1, memo);
        int b = findTrib(n - 2, memo);
        int c = findTrib(n - 3, memo);

        memo.put(currentKey, a + b + c);

        return memo.get(currentKey);
    }

    public int tribonacci(int n) {
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
        return findTrib(n, memo);
    }
}