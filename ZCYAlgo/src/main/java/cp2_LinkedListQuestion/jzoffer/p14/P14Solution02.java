package cp2_LinkedListQuestion.jzoffer.p14;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：lennyz
 * @desc: 2020/11/7 11:06 AM
 * <p>
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 提示：
 * 2 <= n <= 58
 */
public class P14Solution02 {

    /**
     * DP 的方式去解
     * 1. 找到最优子结构
     * 2. 存储中间状态
     * 3. 递推公式
     */
    public int cuttingRope(int n) {

        int[] memo = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            caculate(i, memo);
        }
        return memo[n];

    }

    private void caculate(int m, int[] memo) {
        if (m <= 3) {
            memo[m] = m - 1;
            return;
        }

        int n = m - 3;
        if (memo[n] != 0) {
            memo[m] = memo[n] * 3;
        } else {
            int d3 = n / 3;
            int y3 = n % 3;
            int res = 1;
            while (d3-- > 0) {
                res *= 3;
            }
            memo[m] = res * (y3 == 2 ? 2 : memo[y3]);
        }

    }


    @Test
    public void test() {
        System.out.println(cuttingRope(10));


    }

    public static void main(String[] args) {
        int i = 10;
        List<Integer> list = new ArrayList<>();
        while (i-- > 0) {
            list.add(i);
        }
        System.out.println(list.stream().filter(a -> a > 5).collect(Collectors.toList()));

    }

}
