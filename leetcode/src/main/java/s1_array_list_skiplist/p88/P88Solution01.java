package s1_array_list_skiplist.p88;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @Author ：lennyz
 * @Date: 2021/3/16 10:26 PM
 * @Desc: 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P88Solution01 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int[] res = new int[m + n];
        for (int idx = 0; idx < nums1.length; idx++) {
            if (i < m && j < n) {
                System.out.println(i + " " + j);
                res[idx] = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
                continue;
            } else {
                if (i == m) {
                    res[idx] = nums2[j++];
                } else {
                    res[idx] = nums1[i++];
                }
            }
        }
        System.arraycopy(res, 0, nums1, 0, res.length);
    }


    @Test
    public void test() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(JSON.toJSONString(nums1));
    }
}
