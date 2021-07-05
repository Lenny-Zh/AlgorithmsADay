package recursion_dc_dp.p51;

import org.junit.Test;

import java.util.*;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 输入：4
 * 输出：[
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 */
public class P51Solution02 {

    /**
     * @Author ：lennyz
     * @Date: 2020/12/27 2:31 PM
     * @Desc: 回溯算法
     * 1.
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queen = new int[n];

        Set<Integer> comlumn = new HashSet();
        Set<Integer> diagona1 = new HashSet<>();
        Set<Integer> diagona2 = new HashSet();

        dc(res, queen, n, 0, comlumn, diagona1, diagona2);

        return res;
    }

    public void dc(List<List<String>> res, int[] queen, int n, int row,
                   Set<Integer> comlumn, Set<Integer> diagona1, Set<Integer> diagona2) {
        if (row == n) {
            res.add(generater(queen, n));
            return;
        }

        for (int c = 0; c < n; c++) {
            if (comlumn.contains(c)) {
                continue;
            }
            int s1 = c + row;
            if (diagona1.contains(s1)) {
                continue;
            }
            int s2 = c - row;
            if (diagona2.contains(s2)) {
                continue;
            }

            queen[row] = c;
            comlumn.add(c);
            diagona1.add(s1);
            diagona2.add(s2);
            dc(res, queen, n, row + 1, comlumn, diagona1, diagona2);

            queen[row] = -1;
            comlumn.remove(c);
            diagona1.remove(s1);
            diagona2.remove(s2);
        }
    }

    public List<String> generater(int[] queue, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] arr = new char[n];
            Arrays.fill(arr, '.');
            arr[queue[i]] = 'Q';
            list.add(new String(arr));
        }
        return list;
    }


    @Test
    public void test() {
        System.out.println(solveNQueens(4));
    }
}
