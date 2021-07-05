package recursion_dc_dp.p53;

import org.junit.Test;

/**
 * @author ：lennyz
 * @desc: 2020/11/14 2:57 PM
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */

public class P53Solution01 {

    // 暴力
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int tmp = 0;
            for (int j = i; j < nums.length; j++) {
                tmp += nums[j];
                if (tmp > max) max = tmp;
            }
        }
        return max;
    }



    @Test
    public void test() {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }
}
