package recursion_dc_dp.p198;

import org.junit.Test;

/**
 * @author ：lennyz
 * @desc: 2020/11/12 11:04 PM
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * <p>
 */
public class P198Solution01 {

    // 暴力
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[1];

        int res[] = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            res[i] = Math.max(res[i - 1], res[i - 2] + nums[i]);
        }
        return res[nums.length - 1];
    }

    @Test
    public void test() {
        int arr[] = new int[]{1, 2, 3, 1};
        System.out.println(rob(arr));
    }


}
