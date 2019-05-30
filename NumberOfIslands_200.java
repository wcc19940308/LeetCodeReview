package LeetCode;

public class NumberOfIslands_200 {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean res = dfs(grid, m, n, i, j);
                if (res) cnt++;
            }
        }
        return cnt;
    }

    public boolean dfs(char[][] grid, int m, int n, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0') {
            return false;
        }
        grid[x][y] = '0';
        dfs(grid, m, n, x + 1, y);
        dfs(grid, m, n, x - 1, y);
        dfs(grid, m, n, x, y + 1);
        dfs(grid, m, n, x, y - 1);
        return true;
    }
}
