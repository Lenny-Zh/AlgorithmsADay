package s1_array_list_skiplist.p42;

import org.junit.Test;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class P42Solution01 {

    public int trap(int[] height) {
        int left = 0;
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int curent = height[i];
            if (left > curent) {
                sum += left - curent;
            } else {
                left = curent;
            }
        }
        return sum;
    }

    @Test
    public void test() {
//        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int trap = trap(height);
//        System.out.println(trap);

        for (;;){
            System.out.println("?");
        }
    }


}
