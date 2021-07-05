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
public class P322Solution03 {

    public int coinChange(int[] coins, int amount) {
        // 升序
        if (amount == 0) return 0;
        int arr[] = new int[amount + 1];
        Arrays.fill(arr, -1);
        for (int i = 1; i <= amount; i++) {
            int min = -1;
            int res = -1;
            for (int j = 0; j < coins.length; j++) {
                if (i == coins[j]) {
                    res = 1;
                } else if (i > coins[j] && i - coins[j] > 0 && arr[i - coins[j]] > 0) {
                    res = arr[i - coins[j]] + 1;
                } else {
                    res = -1;
                }
                if (res != -1 && (min == -1 || res < min)) {
                    min = res;
                }
            }
            arr[i] = min;
        }
        System.out.println(JSON.toJSON(arr));
        return arr[amount];
    }


    @Test
    public void test() {
        int[] coins = new int[]{2};
        int amount = 3;
        System.out.println(coinChange(coins, amount));
    }


}
