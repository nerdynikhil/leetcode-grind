class Solution {
    int nthFib(int n, HashMap<Integer, Integer> memo) {

        if (n == 0 || n == 1)
            return n;

        int currentKey = n;

        if (memo.containsKey(currentKey))
            return memo.get(currentKey);

        int a = nthFib(n - 1, memo);
        int b = nthFib(n - 2, memo);

        memo.put(currentKey, a + b);
        return memo.get(currentKey);
    }

    public int fib(int n) {
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
        return nthFib(n, memo);
    }
}