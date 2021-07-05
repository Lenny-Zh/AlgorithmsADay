package cp2_LinkedListQuestion.jzoffer.p12;

import org.junit.Test;

/**
 * @author ：lennyz
 * @desc: 2020/11/7 11:06 AM
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
 * 输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
 *  
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 0 <= n <= 100
 */
public class P12Solution02 {

    public boolean exist(char[][] board, String word) {
        if (board.length * board[0].length < word.toCharArray().length) return false;
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] == word.toCharArray()[0]) {
                    if (checkPath(x, y, board, 0, word.toCharArray(), isVisited)) return true;
                }
            }
        }
        return false;
    }

    // 判断这个位置周边是否有符合要求的
    private boolean checkPath(int x, int y, char[][] board, int sIdx, char[] s, boolean[][] isVisited) {
        if (sIdx == s.length) {
            return true;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || isVisited[x][y]) {
            return false;
        }
        if (board[x][y] == s[sIdx]) {
            isVisited[x][y] = true;
            boolean res = checkPath(x + 1, y, board, sIdx + 1, s, isVisited)
                    || checkPath(x - 1, y, board, sIdx + 1, s, isVisited)
                    || checkPath(x, y + 1, board, sIdx + 1, s, isVisited)
                    || checkPath(x, y - 1, board, sIdx + 1, s, isVisited);
            isVisited[x][y] = false;
            return res;
        }
        return false;
    }

    @Test
    public void test() {

        char[][] input = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCESEEEFS";
        System.out.println(exist(input, word));

    }

}