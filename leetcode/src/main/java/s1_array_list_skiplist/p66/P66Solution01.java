package s1_array_list_skiplist.p66;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @Author ：lennyz
 * @Date: 2021/5/4 5:49 PM
 * @Desc: 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 */
public class P66Solution01 {

    /**
     * 两种情况
     * 1. 不用进位, 相加后直接返回
     * 2. 需要进位, 进位后判断后一位是否要进位
     *
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            int cur = ++digits[i];
            if (cur >= 10) {
                digits[i] = 0;
            } else {
                return digits;
            }
        }

        //  特殊情况, 999
        digits = new int[len +1];
        digits[0] = 1;
        return digits;
    }


    @Test
    public void test() {
        System.out.println(JSON.toJSONString(plusOne(new int[]{9})));
    }
}
