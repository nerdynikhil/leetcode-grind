class Solution {

    private int LCS(String s1, String s2, int i, int j, int m, int n, HashMap<String, Integer> memo){
        if (i>=m || j>=n)
            return 0;
        
        int ans = 0;

        String currentKey = i + "-" +  j;

        if (memo.containsKey(currentKey))
            return memo.get(currentKey);

        if (s1.charAt(i) == s2.charAt(j)){
            ans = 1 + LCS(s1, s2, i+1, j+1, m, n, memo);
        }
        else{
            int a = LCS(s1, s2, i,j+1, m, n, memo);
            int b = LCS(s1, s2, i+1, j, m, n, memo);
            ans = Math.max(a, b);
        }

        memo.put(currentKey, ans);

        return memo.get(currentKey);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m =  text1.length();
        int n = text2.length();
        return LCS(text1,  text2, 0, 0, m, n, new HashMap<String, Integer>());   
    }
}