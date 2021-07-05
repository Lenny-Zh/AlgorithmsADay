package string.p171;

import org.junit.Test;

public class P171Solution01 {

    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int res = 0;
        int time = 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            res += (chars[i] - 'A' + 1) * time;
            time *= 26;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(titleToNumber("AA"));
    }

}
