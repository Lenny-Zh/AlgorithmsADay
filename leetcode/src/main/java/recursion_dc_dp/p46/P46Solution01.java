package recursion_dc_dp.p46;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class P46Solution01 {

    // 递归
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] get = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(nums[i]);
            get[i] = true;
            res(nums, cur, get, 0);
            Arrays.fill(get, false);
            res.add(cur);
        }
        return res;
    }

    public void res(int[] nums, List<Integer> list, boolean[] get, int cIdx) {
        if( cIdx == nums.length){
            return;
        }

        if(!get[cIdx]) {
            list.add(nums[cIdx]);
            get[cIdx] = true;
            for (int i = 0; i < nums.length; i++) {
                res(nums, list, get, cIdx);
            }
        }

        res(nums, list, get, ++cIdx);
    }



    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(JSON.toJSONString(permute));
    }
}
