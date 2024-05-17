class Solution {
    int findMinFallingSum(int currentRow, int currentCol, int m, int n, int[][] grid, HashMap<String, Integer> memo) {

        if (currentCol < 0 || currentCol >= n)
            return 1000001;

        if (currentRow == m - 1)
            return grid[currentRow][currentCol];

        String currentKey = currentRow + "-" + currentCol;

        if (memo.containsKey(currentKey))
            return memo.get(currentKey);

        int moveDown = grid[currentRow][currentCol] + findMinFallingSum(currentRow + 1, currentCol, m, n, grid, memo);

        int moveDiagonallyLeft = grid[currentRow][currentCol]
                + findMinFallingSum(currentRow + 1, currentCol - 1, m, n, grid, memo);

        int moveDiagonallyRight = grid[currentRow][currentCol]
                + findMinFallingSum(currentRow + 1, currentCol + 1, m, n, grid, memo);

        memo.put(currentKey, Math.min(moveDown, Math.min(moveDiagonallyLeft, moveDiagonallyRight)));

        return memo.get(currentKey);
    }

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 1000000;

        for (int currentCol = 0; currentCol < n; currentCol++) {
            int tempAns = findMinFallingSum(0, currentCol, m, n, matrix, new HashMap<String, Integer>());
            ans = Math.min(ans, tempAns);
        }
        return ans;
    }
}