package recursion_dc_dp.p51;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
public class P51Solution01 {

    /**
     * @Author ：lennyz
     * @Date: 2020/12/27 2:31 PM
     * @Desc:
     * 回溯算法
     * 1.
     */
    public List<List<String>> solveNQueens(int n) {
        if (n < 4) return new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                set.add(i + "" + j);
            }
        }

        for (int i = 0; i < n; i++) {
            int[][] booleanArr = new int[n][n];
            dc(new HashSet<String>(set), i, 0, n, n);
        }


        List<List<String>> list = new ArrayList<>();

        return null;
    }

    public int dc(HashSet<String> arr, int x, int y, int n, int less) {
        if (arr.isEmpty()) return less;

        if (x < n && y < n && arr.contains(x + "" + y)) {

            for (int i = 0; i < n; i++) {
                arr.remove(i + "" + y);
                if (i + 1 < n && y + (i - x) > 0 && y + (i - x) < n) {
                    arr.remove((i + 1) + "" + (y + (i - x)));
                }
            }
            if (arr.size() > 0) {
                String next = arr.iterator().next();
                return dc(arr, Integer.parseInt(next.charAt(0) + ""), Integer.parseInt(next.charAt(1) + ""), n, --less);
            }
        }
        return less;
    }


    @Test
    public void test() {
        System.out.println(solveNQueens(4));
    }
}
