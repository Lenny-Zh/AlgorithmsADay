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
public class P120Solution04 {

    /**
     * @author ：lennyz
     * @desc: 2020/11/14 1:42 PM
     *  递归
     *  1. 自定向下
     *  2. 记忆化搜索, 加了一个中间状态
     *
     *  时间复杂度: O(n)
     *  空间复杂度: O(n2)
     *  */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int[][] arr = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        int res =  dpTopToDown(triangle, 0, 0, arr);
        return res;
    }

    public int dpTopToDown(List<List<Integer>> triangle, int n, int last, int[][] arr) {
        if (n == triangle.size() - 1) {
            arr[n][last] = triangle.get(n).get(last);
            return triangle.get(n).get(last);
        }
        // 中间状态
        if (arr[n][last] != 0) return arr[n][last];

        if (last > triangle.get(n).size() - 1) {
            arr[n][last] = triangle.get(n).get(last) + dpTopToDown(triangle, n + 1, last, arr);
        } else {
            arr[n][last] = triangle.get(n).get(last) + (dpTopToDown(triangle, n + 1, last, arr)> dpTopToDown(triangle, n + 1, last + 1, arr)? arr[n+1][last+1]: arr[n+1][last]);
        }
        return arr[n][last];
    }



    @Test
    public void test() {
//        List<List<Integer>> triangle = new ArrayList<>();
//        triangle.add(Arrays.asList(-1));
//        triangle.add(Arrays.asList(2, 3));
//        triangle.add(Arrays.asList(1, -1, -3));

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

//        List<List<Integer>> triangle = new ArrayList<>();
//        triangle.add(Arrays.asList(1));
//        triangle.add(Arrays.asList(-2, -5));
//        triangle.add(Arrays.asList(3, 6, 9));
//        triangle.add(Arrays.asList(-1, 2, 4, -3));

        System.out.println(minimumTotal(triangle));
    }


}
