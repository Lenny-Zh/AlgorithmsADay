package s9_dfs_bfs.p46;

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
public class P46Solution01_dfs {

    // 用深度优先 dfs, 递归写法
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            boolean[] map = new boolean[nums.length];
            List<Integer> cur = new ArrayList<>();
            dfs(nums, map, i, cur, res);
            Arrays.fill(map, false);
        }
        return res;
    }

    public void dfs(int[] nums, boolean[] map, int idx, List<Integer> cur, List<List<Integer>> res) {
        if (map[idx]) {
            return;
        }

        map[idx] = true;
        cur.add(nums[idx]);
        if (cur.size() == nums.length) {
            res.add(cur);
            map[idx] = false;
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != idx) {
                dfs(nums, map, i, new ArrayList<>(cur), res);
            }
        }

        map[idx] = false;
    }


    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(JSON.toJSONString(permute));
    }
}
