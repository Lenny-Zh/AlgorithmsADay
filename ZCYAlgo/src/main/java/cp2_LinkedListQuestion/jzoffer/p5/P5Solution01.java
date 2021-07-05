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
public class P5Solution01 {

    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        char[] newChars = new char[chars.length * 3];
        int j = 0;
        for (int i = 0; i < chars.length; i++, j++) {
            if (chars[i] == 32) {
                newChars[j] = '%';
                newChars[++j] = '2';
                newChars[++j] = '0';
            } else {
                newChars[j] = chars[i];
            }
        }
        String s1 = new String(newChars);
        return s1.trim();
    }

    @Test
    public void test() {
        System.out.println(replaceSpace("haha haha haha kdkk "));
    }
}
