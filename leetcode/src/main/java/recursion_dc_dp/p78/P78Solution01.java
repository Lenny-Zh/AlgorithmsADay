package recursion_dc_dp.p78;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lennyz
 * @desc: 2020/11/17 7:23 AM
 * <p>
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 */
public class P78Solution01 {

    // 分治
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        dc(res, nums, nums.length - 1);
        res.add(new ArrayList<>());
        return res;
    }

    public void dc(List<List<Integer>> res, int[] nums, int idx) {
        if (idx < 0) return;

        if (idx == 0) {
            List<Integer> newList = Arrays.asList(nums[idx]);
            res.add(newList);
        } else {
            dc(res, nums, idx - 1);
            List<List<Integer>> add = new ArrayList<>();
            for (List<Integer> ele : res) {
                List<Integer> newList = new ArrayList<>(ele);
                newList.add(nums[idx]);
                add.add(newList);
            }
            res.addAll(add);
            res.add(Arrays.asList(nums[idx]));
        }
    }

    @Test
    public void test() {
        int arr[] = new int[]{1, 2, 3};
        System.out.println(subsets(arr));
    }


}
