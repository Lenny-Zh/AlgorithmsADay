package leetcode.p20;


import org.junit.Test;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P20Solution1 {

    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        String l1 = "(";
        String r1 = ")";
        String l2 = "{";
        String r2 = "}";
        String l3 = "[";
        String r3 = "]";
        char[] chars = s.trim().toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (i < chars.length - 1 && l1.equals(chars[i] + "") && !r1.equals(chars[i + 1] + "")) {
                return false;
            }
            if (i < chars.length - 1 && l2.equals(chars[i] + "") && !r2.equals(chars[i + 1] + "")) {
                return false;
            }
            if (i < chars.length - 1 && l3.equals(chars[i] + "") && !r3.equals(chars[i + 1] + "")) {
                return false;
            }

            if (i > 0 && !l1.equals(chars[i - 1] + "") && r1.equals(chars[i] + "")) {
                return false;
            }
            if (i > 0 && !l2.equals(chars[i - 1] + "") && r2.equals(chars[i] + "")) {
                return false;
            }
            if (i > 0 && !l3.equals(chars[i - 1] + "") && r3.equals(chars[i] + "")) {
                return false;
            }

        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("(){}}{"));
        System.out.println(isValid("{[]}"));
    }

}
