package s1_array_list_skiplist.p56;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class P56Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> list = new ArrayList<>();

        for (int[] arr : intervals) {
            if (list.isEmpty()) {
                list.add(arr);
            } else {
                int[] latest = list.get(list.size() - 1);
                if (latest[1] >= arr[0]) {
                    if (latest[1] <= arr[1]) {
                        latest[1] = arr[1];
                    }
                } else {
                    list.add(arr);
                }
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    @Test
    public void test() {
        int[][] nums = new int[][]{{1, 4}, {0, 2}, {3, 5}};
        int[][] res = merge(nums);
        System.out.println(JSON.toJSONString(res));
    }

}
