package s11_binary_search.p33;


import org.junit.Test;

/**
 * @author ：lennyz
 * @desc: 2020/11/21 4:22 PM
 * <p>
 * 给你一个整数数组 nums ，和一个整数 target 。
 * 该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * <p>
 * 示例 1:
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * <p>
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * nums 肯定会在某个点上旋转
 * -10^4 <= target <= 10^4
 */
public class P33Solution01 {

    // 暴力
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if( target == nums[i]){
                return i;
            }
        }
        return -1;
    }


    @Test
    public void test() {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
