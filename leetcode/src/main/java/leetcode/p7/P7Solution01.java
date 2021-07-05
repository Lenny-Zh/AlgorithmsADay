package leetcode.p7;

import org.junit.Test;

public class P7Solution01 {

    public int reverse(int x) {
        if (x > 0 && x < 10) {
            return x;
        }
        if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) {
            return 0;
        }

        StringBuilder s = new StringBuilder(Math.abs(x) + "");
        String s1 = s.reverse().toString();
        Long l = Long.valueOf(s1);
        if (l > Integer.MAX_VALUE) {
            return 0;
        }
        if (x < 0) {
            return -l.intValue();
        } else {
            return l.intValue();
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
