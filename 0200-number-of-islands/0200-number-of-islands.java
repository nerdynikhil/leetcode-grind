class Solution {

    /*
     * 
     * if (visited[currentCity])
     * return;
     * 
     * visited[currentCity] = true;
     * 
     * int[] neighbours = graph[currentCity];
     * 
     * for (int i = 0; i < n; i++) {
     * if (neighbours[i] == 1) {
     * dfs(graph, i, n, visited);
     * }
     * }
     * 
     * return;
     * 
     */

    void findNumberOfIslands(char[][] grid, int currentRow, int currentCol, int m, int n){

        if (currentRow< 0 || currentCol <0 || currentRow >= m || currentCol >= n || grid[currentRow][currentCol] == '0')
            return;
 
        grid[currentRow][currentCol] = '0';
        
        findNumberOfIslands(grid, currentRow-1, currentCol, m, n);
        findNumberOfIslands(grid, currentRow+1, currentCol, m, n);
        findNumberOfIslands(grid, currentRow, currentCol-1, m, n);
        findNumberOfIslands(grid, currentRow, currentCol+1, m, n);
        return;
    }

    public int numIslands(char[][] grid) {
        int ans = 0;

        int m = grid.length;
        int n = grid[0].length;

        for (int currentRow = 0; currentRow < m; currentRow++) {
            for (int currentCol = 0; currentCol < n; currentCol++) {
                if (grid[currentRow][currentCol] == '1') {
                    findNumberOfIslands(grid, currentRow, currentCol, m, n);
                    ans += 1;
                }
            }
        }
        return ans;
    }
}