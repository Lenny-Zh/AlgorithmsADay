package recursion_dc_dp.p322;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author ：lennyz
 * @desc: 2020/11/12 11:04 PM
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class P322Solution01 {

    // 错误 错误
    public int coinChange(int[] coins, int amount) {
        // 升序
        int[] sortCoin = Arrays.stream(coins).sorted().toArray();
        int resArr[][] = new int[coins.length ][coins.length];
        dp(sortCoin, amount, coins.length-1, 0, resArr);
        System.out.println(JSON.toJSON(resArr));
        return -1;
    }

    private int dp(int[] sortCoin, int reduceAmount, int idx, int deep, int[][] resArr) {
        if(idx >= sortCoin.length || deep >= sortCoin.length){
            return 0;
        }

        int tmpCnt = 0;

        for (int j = 0; j < reduceAmount / sortCoin[idx]; j++) {

            int tempAmount = reduceAmount - j * sortCoin[idx];

            if (tempAmount > sortCoin[idx]) {
                tmpCnt = tempAmount / sortCoin[idx];
                int resAmount = tempAmount % sortCoin[idx] + j * sortCoin[idx];
                if (resAmount == 0) {
                    resArr[idx][deep] = tmpCnt;
                    return resAmount - j;
                } else {
                    int dpCnt = dp(sortCoin, resAmount, idx + 1, deep + 1, resArr);
                    if (dpCnt > 0) {
                        resArr[idx][deep] = tmpCnt + dpCnt;
                    }
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] coins = new int[]{1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }


}
