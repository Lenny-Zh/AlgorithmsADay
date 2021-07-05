package s1_array_list_skiplist.p118;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class P118Solution01 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (i > 1) {
                    List<Integer> lastLevel = res.get(i - 1);
                    int left = (j - 1 < 0) ? 0 : lastLevel.get(j - 1);
                    int right = j >= lastLevel.size() ? 0 : lastLevel.get(j);
                    cur.add(left + right);
                } else {
                    cur.add(1);
                }
            }
            res.add(cur);
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(generate(5)));

    }
}
