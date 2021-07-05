package leetcode.p7;

import org.junit.Test;

public class P7Solution02 {

    public int reverse(int x) {
        if (x > 0 && x < 10) {
            return x;
        }
        if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) {
            return 0;
        }
        boolean isFS = (x < 0);

        StringBuffer s = new StringBuffer(Math.abs(x) + "");
        try {
            if (isFS) {
                return -Integer.parseInt(s.reverse().toString());
            } else {
                return Integer.parseInt(s.reverse().toString());
            }
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @Test
    public void test() {
        System.out.println(reverse(-2147483648));
        System.out.println(reverse(-123));
        System.out.println(reverse(223));
        System.out.println(reverse(-423));
    }
}
