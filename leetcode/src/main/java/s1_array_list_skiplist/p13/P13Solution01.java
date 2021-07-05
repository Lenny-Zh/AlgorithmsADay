package s1_array_list_skiplist.p13;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ：lennyz
 * @Date: 2021/3/14 1:09 PM
 * @Desc: 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */
public class P13Solution01 {

    // 1.暴力
    // 2. 排序 + 双指针
    public List<List<Integer>> threeSum(int[] nums) {
        // 1.排序
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 2. 遍历
        for (int a = 0; a < n; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }

            int target = -nums[a];
            // 这里获得c的指针
            int c = n - 1;
            for (int b = a + 1; b < n; b++) {
                // 排除 1,2,2 这种情况, 第二个数的枚举与上一层不同
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                // 保证b 在 c 的左边,排除掉不可能的条件
                /**
                 * 双指针
                 * 如果满足 a+b+c = 0, 那么到下一层b'时候, b' > b
                 * 要满足 a+b'+c' = 0 , 因为 b'>b, 必须满足 c' < c
                 *
                 */
                while (c > b && nums[b] + nums[c] > target) {
                    c--;
                }
                if (b == c) {
                    break;
                }
                if (nums[b] + nums[c] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[a]);
                    list.add(nums[b]);
                    list.add(nums[c]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(JSON.toJSONString(threeSum(nums)));
    }
}
