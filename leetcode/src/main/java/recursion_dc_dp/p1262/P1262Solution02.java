package recursion_dc_dp.p1262;

import org.junit.Test;

/**
 * @Author ：lennyz
 * @Date: 2021/7/5 9:39 PM
 * @Desc:
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 *
 *
 * 思路
 * 评论区有人看不懂，那我举个例子吧。
 * 原数组nums = [1, 6, 7, 11, 3, 5, 65, 987, 12, 43, 8, 55, 34, 654, 2, 77]，总和为1970，1970 % 3 = 2.
 * 按照模3余数分类并排序后：
 *
 * zeros = [3, 6, 12, 654, 987]
 * ones = [1, 7, 34, 43, 55]
 * twos = [2, 5, 8, 11, 65, 77]
 * 面对余2的总和有两种操作办法：
 *
 * 去掉最小一个余2的数，2.
 * 去掉最小两个余1的数，1+7.
 * 对这两种做法进行比较，1+7 > 2，所以选择去掉2，最后的结果即为1970 - 2 = 1968.
 *
 * 补充:
 * 数组和为sum,被删数字和为del,则需del %3 == sum % 3;
 *
 */
public class P1262Solution02 {

    /**
     * @Author ：lennyz
     * @Date: 2021/7/5 9:40 PM
     * @Desc:
     * [1,2] -> 3
     * [1,2,3] -> 6
     * [1,2,3,4] -> 10-1 = 9
     *
     */
    public int maxSumDivThree(int[] nums) {







        return 0;
    }

    @Test
    public void test() {


    }
}
