package s1_array_list_skiplist.p46;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        return res;
    }



    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(JSON.toJSONString(permute));
    }
}
