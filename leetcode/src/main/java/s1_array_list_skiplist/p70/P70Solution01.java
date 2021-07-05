package s1_array_list_skiplist.p70;

import org.junit.Test;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 */
public class P70Solution01 {

    //
    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        int[] resArr = new int[n];
        for (int i = 0; i < n; i++) {
            if(i <=3){
                resArr[i] = i;
            }else {
                resArr[i] = resArr[i-1] + resArr[i-2];
            }
        }
        return resArr[n-1];
    }




    @Test
    public void test() {
        System.out.println(climbStairs(4));
    }
}
