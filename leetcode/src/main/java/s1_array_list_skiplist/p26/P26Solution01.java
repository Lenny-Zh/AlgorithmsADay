package s1_array_list_skiplist.p26;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 *  
 */
public class P26Solution01 {

    /**
     * @param nums
     * @return
     * @Tag 双指针算法
     */

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        System.arraycopy(nums, 0, nums, 0, i+1);
        return i+1;
    }

    @Test
    public  void test() {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int val = removeDuplicates(nums);
        System.out.println(JSON.toJSONString(nums));
        System.out.println(val);

    }


}
