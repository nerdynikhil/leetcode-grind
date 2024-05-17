class Solution {
    int findTotalPaths(int m, int n, int currentRow, int currentCol, HashMap<String, Integer> memo) {

        if (currentRow == m - 1 && currentCol == n - 1)
            return 1;
        if (currentRow >= m || currentCol >= n)
            return 0;

        String currentKey = currentRow + "-" + currentCol;

        if (memo.containsKey(currentKey))
            return memo.get(currentKey);

        int moveRight = findTotalPaths(m, n, currentRow, currentCol + 1, memo);
        int moveDown = findTotalPaths(m, n, currentRow + 1, currentCol, memo);

        memo.put(currentKey, moveRight + moveDown);

        return memo.get(currentKey);
    }

    public int uniquePaths(int m, int n) {
        return findTotalPaths(m, n, 0, 0, new HashMap<String, Integer>());
    }
}