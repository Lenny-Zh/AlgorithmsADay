package recursion_dc_dp.p51;

import java.util.*;

public class P51Solution_Offical {

    public List<List<String>> solveNQueens(int n) {
        // 结果
        List<List<String>> solutions = new ArrayList<List<String>>();
        //
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        // 列 , 不记录行因为一行只能放一个
        Set<Integer> columns = new HashSet<Integer>();
        // 对角线 行下标与列下标之差相等
        Set<Integer> diagonals1 = new HashSet<Integer>();
        // 对角线 行下标与列下标之和相等
        Set<Integer> diagonals2 = new HashSet<Integer>();

        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);

        return solutions;
    }

    public void backtrack(List<List<String>> solutions, int[] queens, int n, int row,
                          Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        // 最后一行
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                // 满足条件, 标记
                queens[row] = i; //  row 行, i列, 位置放置皇后
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                // 进入下一行
                backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);

                // 清除当前标记
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

}
