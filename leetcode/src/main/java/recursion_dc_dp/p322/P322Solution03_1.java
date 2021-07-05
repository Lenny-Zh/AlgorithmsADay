package recursion_dc_dp.p322;

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
public class P322Solution03_1 {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int arr[] = new int[amount + 1];
        Arrays.fill(arr, amount + 1);
        // 初始值
        arr[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    arr[i] = Math.min(arr[i], arr[i - coins[j]] + 1);
                }
            }
        }
        return arr[amount] == amount+1? -1: arr[amount];
    }


    @Test
    public void test() {
        int[] coins = new int[]{2};
        int amount = 3;
        System.out.println(coinChange(coins, amount));
    }


}
