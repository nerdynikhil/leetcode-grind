class Solution {
    private int totalWays(int currentStair, int targetStair, HashMap<Integer, Integer> mp) {
        if (currentStair == targetStair)
            return 1;
        if (currentStair > targetStair)
            return 0;

        int currentKey = currentStair;

        if (mp.containsKey(currentKey))
            return mp.get(currentKey);

        int oneJump = totalWays(currentStair + 1, targetStair, mp);
        int twoJumps = totalWays(currentStair + 2, targetStair, mp);

        mp.put(currentKey, oneJump + twoJumps);

        return mp.get(currentKey);
    }

    public int climbStairs(int n) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        return totalWays(0, n, mp);
    }
}