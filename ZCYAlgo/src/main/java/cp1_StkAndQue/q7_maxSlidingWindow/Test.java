package cp1_StkAndQue.q7_maxSlidingWindow;

import com.alibaba.fastjson.JSON;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值
 * <p>
 * 难度 尉 2
 */
public class Test {

    public static void main(String[] args) {
        int[] num = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        Solution01 s1 = new Solution01();
        int[] res = s1.maxSlidingWindow(num, k);
        System.out.println(JSON.toJSONString(res));

    }


}
