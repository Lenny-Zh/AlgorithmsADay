package s1_array_list_skiplist.p283;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @author ：lennyz
 * @desc: 2020/11/23 10:58 PM
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P283Solution01 {

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) nums[i] = 0;
                j++;
            }
        }
        System.out.println(JSON.toJSON(nums));
    }

    @Test
    public void test() {
        moveZeroes(new int[]{0,1,0,3,12});    // 返回 -1 (未找到)
    }
}
