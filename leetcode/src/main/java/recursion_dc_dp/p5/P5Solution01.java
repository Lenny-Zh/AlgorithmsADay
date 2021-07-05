package recursion_dc_dp.p5;

import org.junit.Test;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * P(i,j)=P(i+1,j−1)∧(Si == Sj)
 * <p>
 * 动态规划解题
 */
public class P5Solution01 {

    // 动态规划, 要从最小的组合开始探索
    public String longestPalindrome(String s) {
        Integer len = s.length();
        if (len <= 1) return s;

        boolean[][] flag = new boolean[len][len];
        String res = "";
        for (int dif = 0; dif < len; dif++) {
            for (int i = 0; i < len - dif; i++) {
                int j = i + dif;
                if (dif == 0) {
                    flag[i][j] = true;
                } else if (dif == 1) {
                    flag[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    flag[i][j] = (s.charAt(i) == s.charAt(j) && flag[i + 1][j - 1]);
                }
                if (flag[i][j] && dif +1 > res.length()) {
                    res = s.substring(i, j+1);
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        String abc = "ac";
        String s = longestPalindrome(abc);
        System.out.println(s);
    }


}
