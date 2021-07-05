package leetcode.p9;

import org.junit.Test;

public class P9Solution01 {

    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0) return false;
        try {
            StringBuilder str = new StringBuilder(x + "");
            return x == Integer.parseInt(str.reverse().toString());
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(isPalindrome(-2147483648));
        System.out.println(isPalindrome(121));
    }
}
