package s1_array_list_skiplist.p406;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author ：lennyz
 * @Date: 2021/3/15 10:41 PM
 * @Desc: 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people{i} = {hi, ki} 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * <p>
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
 * 其中 queue{j} = {hj, kj} 是队列中第 j 个人的属性（queue{0} 是排在队列前面的人）。
 * <p>
 */
public class P406Solution01 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (int[] o1, int[] o2) -> o2[0] - o1[0]);
        List<int[]> res = new ArrayList<>();

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][2]);
    }

    @Test
    public void test() {
        int[][] arr = new int[][]{{9, 0}, {7, 0}, {1, 9}, {3, 0}, {2, 7}, {5, 3}, {6, 0}, {3, 4}, {6, 2}, {5, 2}};
        System.out.println(JSON.toJSONString(reconstructQueue(arr)));

    }
}
