class Solution {

    private boolean isValid(int i, int j, int n, int m, int[][] grid) {
        return i >= 0 && i < n && j >= 0 && j < m && grid[i][j] == 1;
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int fresh = 0, time = 0;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0)
            return 0;

        int[] ax = { 1, -1, 0, 0 };
        int[] ay = { 0, 0, 1, -1 };

        while (!q.isEmpty()) {
            int size_q = q.size();
            int temp = 0;
            while (size_q != 0) {
                int[] p = q.poll();
                int x1 = p[0];
                int y1 = p[1];

                for (int i = 0; i < 4; i++) {
                    int x = ax[i] + x1;
                    int y = ay[i] + y1;

                    if (isValid(x, y, n, m, grid)) {
                        temp++;
                        grid[x][y] = 2;
                        q.add(new int[] { x, y });
                    }
                }

                size_q--;
            }
            if (temp != 0)
                time++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    time = 0;
                    break;
                }
            }
        }

        if (time == 0)
            return -1;
        else
            return time;

    }
}