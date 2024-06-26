class Solution {
    private int LCS(String s1, String s2, int i, int j, int m, int n, HashMap<String, Integer> memo) {
        if (i >= m || j >= n)
            return 0;

        int ans = 0;

        String currentKey = i + "-" + j;

        if (memo.containsKey(currentKey))
            return memo.get(currentKey);

        if (s1.charAt(i) == s2.charAt(j)) {
            ans = 1 + LCS(s1, s2, i + 1, j + 1, m, n, memo);
        } else {
            int a = LCS(s1, s2, i, j + 1, m, n, memo);
            int b = LCS(s1, s2, i + 1, j, m, n, memo);
            ans = Math.max(a, b);
        }

        memo.put(currentKey, ans);

        return memo.get(currentKey);
    }

    public int longestPalindromeSubseq(String s) {
        return LCS(s, new StringBuilder(s).reverse().toString(), 0, 0, s.length(), s.length(),
                new HashMap<String, Integer>());
    }
}