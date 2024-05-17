class Solution {
    int findCheapestPathSum(int currentRow, int currentCol, int m, int n, int[][] grid, HashMap<String, Integer> memo) {

        if (currentRow >= m || currentCol >= n)
            return 100001;

        if (currentRow == m - 1 && currentCol == n - 1)
            return grid[currentRow][currentCol];

        String currentKey = currentRow + "-" + currentCol;

        if (memo.containsKey(currentKey))
            return memo.get(currentKey);

        int moveRight = grid[currentRow][currentCol]
                + findCheapestPathSum(currentRow, currentCol + 1, m, n, grid, memo);

        int moveDown = grid[currentRow][currentCol] + findCheapestPathSum(currentRow + 1, currentCol, m, n, grid, memo);

        memo.put(currentKey, Math.min(moveRight, moveDown));

        return memo.get(currentKey);

    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return findCheapestPathSum(0, 0, m, n, grid, new HashMap<String, Integer>());
    }
}