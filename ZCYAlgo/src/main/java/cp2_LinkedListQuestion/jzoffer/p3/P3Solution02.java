package cp2_LinkedListQuestion.jzoffer.p3;

import org.junit.Test;

/**
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * <p>
 * 输出：
 * 2 或 3
 * <p>
 * 2 <= n <= 100000
 */
public class P3Solution02 {

    public int findRepeatNumber(int[] nums) {
        boolean arr[] = new boolean[nums.length];
        for (int i : nums) {
            if (arr[i]) return i;
            arr[i] = true;
        }
        return 0;
    }

    @Test
    public void test() {
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
