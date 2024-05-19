class Solution {
    int minimumCuts(String s, int start, int end, HashMap<String, Integer> memo) {

        if (isPallindrome(s, start, end))
            return 0;

        String currentKey = start + "-" + end; 

        if (memo.containsKey(currentKey))
            return memo.get(currentKey);

        int ans = 100000;

        int tempAns = 0;

        for (int i = start; i < end; i++) {
            if (isPallindrome(s, start, i)) {
                tempAns = 1 + minimumCuts(s, i + 1, end, memo);
                ans = Math.min(ans, tempAns);
            }
        }

        memo.put(currentKey, ans);
        return memo.get(currentKey);
    }

    boolean isPallindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))
                return false;

            start += 1;
            end -= 1;
        }

        return true;
    }

    public int minCut(String s) {
        return minimumCuts(s, 0, s.length() - 1, new HashMap<String, Integer>());
    }
}