package s9_dfs_bfs.p200;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class P200Solution02 {

    // 广度优先
    public int numIslands(char[][] grid) {
        if (grid.length <= 0) return grid.length;
        int r = grid.length;
        int c = grid[0].length;
        int num = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    public void bfs(char[][] grid, int i, int j) {
        Queue<int[]> list = new LinkedList<>();
        list.add(new int[]{i, j});
        while (!list.isEmpty()) {
            int[] cur = list.remove();
            i = cur[0];
            j = cur[1];
            if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length
                    && grid[i][j] == '1') {
                grid[i][j] = '0';
                list.add(new int[]{i, j + 1});
                list.add(new int[]{i, j - 1});
                list.add(new int[]{i + 1, j});
                list.add(new int[]{i - 1, j});
            }
        }
    }

    @Test
    public void test() {
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(JSON.toJSON(numIslands(grid)));
    }


}
