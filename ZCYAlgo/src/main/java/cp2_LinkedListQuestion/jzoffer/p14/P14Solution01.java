package cp2_LinkedListQuestion.jzoffer.p14;

import org.junit.Test;

/**
 * @author ：lennyz
 * @desc: 2020/11/7 11:06 AM
 * <p>
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 提示：
 * 2 <= n <= 58
 */
public class P14Solution01 {

    /**
     * 任何大于1的数都可由2和3相加组成（根据奇偶证明）
     * 因为2*2=1*4，2*3>1*5, 所以将数字拆成2和3，能得到的积最大
     * 因为2*2*2<3*3, 所以3越多积越大 时间复杂度O(n/3)，用幂函数可以达到O(log(n/3)), 因为n不大，所以提升意义不大，我就没用。 空间复杂度常数复杂度O(1)
     */
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }

        int s = n / 3;
        int y = n % 3;
        int sum = 0;

        while (s-- > 0) {
            if (sum == 0) {
                sum = 3;
            } else {
                sum *= 3;
            }
        }

        int s2 = y / 2;
        int y2 = y % 2;
        while (s2-- > 0) {
            sum *= 2;
        }
        return sum * y2;
    }

    @Test
    public void test() {
        System.out.println(cuttingRope(10));


    }

}
