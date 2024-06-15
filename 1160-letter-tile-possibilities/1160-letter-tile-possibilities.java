class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> result = new HashSet<>();
        boolean[] used = new boolean[tiles.length()];
        StringBuilder current = new StringBuilder();
        char[] tileArray = tiles.toCharArray();

        Arrays.sort(tileArray);

        backtrack(result, used, current, tileArray);

        return result.size();
    }

    private void backtrack(Set<String> result, boolean[] used, StringBuilder current, char[] tiles) {
        for (int i = 0; i < tiles.length; i++) {
            if (used[i] || (i > 0 && tiles[i] == tiles[i - 1] && !used[i - 1]))
                continue;

            used[i] = true;
            current.append(tiles[i]);

            result.add(current.toString());

            backtrack(result, used, current, tiles);

            used[i] = false;
            current.deleteCharAt(current.length() - 1);
        }
    }
}