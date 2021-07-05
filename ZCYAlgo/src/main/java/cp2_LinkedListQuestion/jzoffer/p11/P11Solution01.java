package cp2_LinkedListQuestion.jzoffer.p11;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：lennyz
 * @desc: 2020/11/7 11:06 AM
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
 * 输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
 *  
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 0 <= n <= 100
 */
public class P11Solution01 {

    // 找最小值
    public int minArray(int[] numbers) {
        int idx = numbers[0];
        for (int i : numbers) {
            if (i < idx) {
                idx = i;
            }
        }
        return idx;
    }

    @Test
    public void test() {

    }

}