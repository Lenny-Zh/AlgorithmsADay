package s13_bit.p231;

/**
 * @Author ：lennyz
 * @Date: 2021/1/4 9:11 PM
 * @Desc: 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 */
public class P231_Solution01 {

    /**
     * 循环32次, 判断每一位上是否有1
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        P231_Solution01 p191_solution01 = new P231_Solution01();
        System.out.println(p191_solution01.isPowerOfTwo(1));
        System.out.println(p191_solution01.isPowerOfTwo(2));
    }


}
