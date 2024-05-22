class Solution {
    int minOperations(String s1, String s2, int m, int n, int i, int j, HashMap<String, Integer> memo) {
        if (i >= m)
            return n - j;

        if (j >= n)
            return m - i;

        int ans = 0;

        String currentKey = i + "-" + j;

        if (memo.containsKey(currentKey))
            return memo.get(currentKey);

        if (s1.charAt(i) == s2.charAt(j)) {
            ans = minOperations(s1, s2, m, n, i + 1, j + 1, memo);
        } else {
            int insert = 1 + minOperations(s1, s2, m, n, i, j + 1, memo);
            int delete = 1 + minOperations(s1, s2, m, n, i + 1, j, memo);
            int replace = 1 + minOperations(s1, s2, m, n, i + 1, j + 1, memo);
            ans = Math.min(insert, Math.min(delete, replace));
        }

        memo.put(currentKey, ans);

        return memo.get(currentKey);
    }

    public int minDistance(String word1, String word2) {
        return minOperations(word1, word2, word1.length(), word2.length(), 0, 0, new HashMap<String, Integer>());
    }
}