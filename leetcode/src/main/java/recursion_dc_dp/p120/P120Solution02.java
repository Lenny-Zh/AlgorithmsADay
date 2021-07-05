package recursion_dc_dp.p120;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lennyz
 * @desc: 2020/11/12 11:04 PM
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * <p>
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class P120Solution02 {

    // 错误 
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        return triangle.get(0).get(0) + dp(triangle, 1, 0);
    }

    public int dp(List<List<Integer>> triangle, int n, int last) {
        if(n == triangle.size()) return 0;
        int min = 0;
        if (last < triangle.get(n).size()) {
            if (triangle.get(n).get(last) > triangle.get(n).get(last + 1)) {
                min = triangle.get(n).get(last + 1);
                last = last + 1;
            } else {
                min = triangle.get(n).get(last);
            }
        } else {
            min = triangle.get(n).get(last);
        }
        System.out.println(min + " : " + last);
        return min + dp(triangle, n + 1, last);
    }

    @Test
    public void test() {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(3, 2));
        triangle.add(Arrays.asList(-3, 1, -1));

//        triangle.add(Arrays.asList(4, 1, 8, 3));
//        List<List<Integer>> triangle = new ArrayList<>();
//        triangle.add(Arrays.asList(2));
//        triangle.add(Arrays.asList(3, 4));
//        triangle.add(Arrays.asList(6, 5, 7));
//        triangle.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(minimumTotal(triangle));
    }


}
