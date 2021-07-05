package cp2_LinkedListQuestion.jzoffer.p12;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：lennyz
 * @desc: 2020/11/7 11:06 AM
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 0 <= n <= 100
 */
public class P12Solution01 {

    // 失败, 条件过多, 需要优化
    public boolean exist(char[][] board, String word) {
        int x = 0;
        int y = 0;
        int xMax = board.length;
        int yMax = board[0].length;

        char first = word.toCharArray()[0];

        boolean getFirst = false;
        flag:
        for (; x < xMax; x++) {
            for (y = 0; y < yMax; y++) {
                if (board[x][y] == first) {
                    getFirst = true;
                    break flag;
                }
            }
        }
        if (!getFirst) {
            return false;
        }

        int match = 1;
        Set<String> filter = new HashSet<>();
        filter.add(x + "_" + y);
        for (int idx = 1; idx < word.toCharArray().length; idx++) {
            char s = word.toCharArray()[idx];


            if (x - 1 >= 0 && board[x - 1][y] == s && !filter.contains(x - 1 + "_" + y)) {
                filter.add((x - 1) + "_" + y);
                x = x - 1;
                match++;
                continue;
            }
            if (x + 1 < xMax && board[x + 1][y] == s && !filter.contains(x + 1 + "_" + y)) {
                filter.add((x + 1) + "_" + y);
                x = x + 1;
                match++;
                continue;
            }
            if (y - 1 >= 0 && board[x][y - 1] == s && !filter.contains(x + "_" + (y - 1))) {
                filter.add(x + "_" + (y - 1));
                y = y - 1;
                match++;
                continue;
            }
            if (y + 1 < yMax && board[x][y + 1] == s && !filter.contains(x + "_" + (y + 1))) {
                filter.add(x + "_" + (y + 1));
                y = y + 1;
                match++;
                continue;
            }

        }

        return match == word.toCharArray().length;
    }


    @Test
    public void test() {
        char[][] input = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";

        char[][] input2 = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};

//        System.out.println(exist(input, word));

        System.out.println(exist(input2, "AAB"));


    }

}
