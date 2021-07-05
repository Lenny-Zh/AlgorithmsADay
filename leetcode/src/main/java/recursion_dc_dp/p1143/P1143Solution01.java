package recursion_dc_dp.p1143;

import org.junit.Test;

public class P1143Solution01 {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] aArr = text1.toCharArray();
        char[] bArr = text2.toCharArray();

        int[][] res = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i < aArr.length + 1; i++) {
            for (int j = 1; j < bArr.length + 1; j++) {
                if (aArr[i - 1] == bArr[j - 1]) {
                    res[i][j] = res[i - 1][j - 1] + 1;
                } else {
                    res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
                }

            }
        }
        return res[aArr.length][bArr.length];
    }


    @Test
    public void test() {
        // "bsbininm"
        //"jmjkbkjkv"
        System.out.println(longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
    }


}
