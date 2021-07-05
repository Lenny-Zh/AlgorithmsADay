package s13_bit.p190;

/**
 * @Author ：lennyz
 * @Date: 2021/1/4 9:11 PM
 * @Desc: 颠倒给定的 32 位无符号整数的二进制位。
 */
public class P190_Solution01 {

    /**
     * @param n
     * @return
     */
    public long reverseBits(long n) {
        long res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) + (n & 1);
            n >>= 1;
        }
        return res;

    }

    public static void main(String[] args) {
        P190_Solution01 p191_solution01 = new P190_Solution01();
        System.out.println(p191_solution01.reverseBits(  4294967293L));
        System.out.println(p191_solution01.reverseBits(2));
    }


}
