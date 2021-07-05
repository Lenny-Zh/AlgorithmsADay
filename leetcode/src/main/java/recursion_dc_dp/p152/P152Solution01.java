package recursion_dc_dp.p152;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P152Solution01 {


    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int[][] arr = new int[nums.length][nums.length];
        arr[0][0] = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (j == i) {
                    arr[i][j] = nums[i];
                } else {
                    arr[i][j] = nums[j] * arr[i][j - 1];
                }
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        System.out.println(JSON.toJSON(arr));
        return max;
    }

    @Test
    public void test() {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
    }
}
