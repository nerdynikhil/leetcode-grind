class Solution {

    int findTotalPaths(int currentRow, int currentCol, int m, int n, int[][] obstacleGrid,
            HashMap<String, Integer> memo) {

        if (currentRow >= m || currentCol >= n || obstacleGrid[currentRow][currentCol] == 1)
            return 0;
        if (currentRow == m - 1 && currentCol == n - 1)
            return 1;

        String currentKey = currentRow + "-" + currentCol;

        if (memo.containsKey(currentKey))
            return memo.get(currentKey);
        int moveRight = findTotalPaths(currentRow, currentCol + 1, m, n, obstacleGrid, memo);

        int moveDown = findTotalPaths(currentRow + 1, currentCol, m, n, obstacleGrid, memo);

        memo.put(currentKey, moveRight + moveDown);

        return memo.get(currentKey);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return findTotalPaths(0, 0, m, n, obstacleGrid, new HashMap<String, Integer>());
    }
}