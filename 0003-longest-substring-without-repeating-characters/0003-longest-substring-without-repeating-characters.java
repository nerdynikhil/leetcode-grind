class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            freq[endChar]++;

            while (freq[endChar] > 1) {
                char startChar = s.charAt(start);
                freq[startChar]--;
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}