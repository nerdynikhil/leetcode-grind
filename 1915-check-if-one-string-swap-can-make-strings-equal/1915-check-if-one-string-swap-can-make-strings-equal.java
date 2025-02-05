class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2))
            return true;

        int[] freq1 = new int[26], freq2 = new int[26];
        int diffCount = 0;

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);

            if (c1 != c2) {
                diffCount++;
                if (diffCount > 2)
                    return false;
            }

            freq1[c1 - 'a']++;
            freq2[c2 - 'a']++;
        }

        return Arrays.equals(freq1, freq2);
    }
}