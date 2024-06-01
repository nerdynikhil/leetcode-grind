class Solution {
    public int findPermutationDifference(String s, String t) {
        HashMap<Character, Integer> mp1 = new HashMap<>();
        HashMap<Character, Integer> mp2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            mp1.put(s.charAt(i), i);
            mp2.put(t.charAt(i), i);
        }

        int difference = 0;

        for (int i = 0; i < s.length(); i++) {
            difference += Math.abs(mp1.get(s.charAt(i)) - mp2.get(s.charAt(i)));
        }
        return difference;
    }
}