class Solution {

    static int nthCatalan(int n) {
        if (n == 0 || n == 1)
            return 1;

        int ways = 0;

        for (int i = 0; i < n; i++) {
            ways += nthCatalan(i) * nthCatalan(n - i - 1);
        }
        return ways;
    }

    public int numTrees(int n) {
        return nthCatalan(n);
    }
}