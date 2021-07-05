package recursion_dc_dp.p322;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

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
public class P322Solution02 {

    // 错误 错误
    public int coinChange(int[] coins, int amount) {
        // 升序
        if (amount == 0) return 0;
        int resArr[] = new int[amount];
        int cntArr[] = new int[coins.length];
        for (int i = 0; i < coins.length; i++) {
            int res = dp(coins, amount - coins[i], resArr);
            if (res <= 0) {
                if( amount % coins[i] == 0){
                    cntArr[i] = 1;
                }else {
                    cntArr[i] = -1;
                }
            } else {
                cntArr[i] = res + 1;
            }
        }
        int min = -1;
        for (int res : cntArr) {
            if (res != -1 || (res > 0 && res < min)) min = res;
        }
        System.out.println(JSON.toJSON(cntArr));
        return min;
    }

    private int dp(int[] sortCoin, int amount, int[] resArr) {
        if (amount <= 0) return 0;

        int[] arrCmp = new int[sortCoin.length];
        for (int i = 0; i < sortCoin.length; i++) {
            if (amount >= sortCoin[i]) {
                if (amount % sortCoin[i] == 0) {
                    arrCmp[i] = amount / sortCoin[i];
                } else {
                    int res = dp(sortCoin, amount - sortCoin[i], resArr);
                    if (res > 0) {
                        arrCmp[i] = res + 1;
                    } else {
                        arrCmp[i] = -1;
                    }
                }
            } else {
                arrCmp[i] = -1;
            }
        }
        int min = -1;
        for (int res : arrCmp) {
            if (res != -1 || (res > 0 && res < min)) min = res;
        }
        return min;
    }

    @Test
    public void test() {
        int[] coins = new int[]{2,5,10,1};
        int amount = 27;
        System.out.println(coinChange(coins, amount));
    }


}
