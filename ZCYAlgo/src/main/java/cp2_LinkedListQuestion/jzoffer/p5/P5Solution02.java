package cp2_LinkedListQuestion.jzoffer.p5;

import org.junit.Test;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * 0 <= s的长度 <= 10000
 */
public class P5Solution02 {

    public String replaceSpace(String s) {
        return s.replaceAll("\\ ", "%20");
    }

    @Test
    public void test() {
        System.out.println(replaceSpace("haha haha haha kdkk "));
    }
}
