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
public class P20Solution4 {

    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        char[] arr = s.trim().toCharArray();
        if (arr.length % 2 == 1) {
            return false;
        }

        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s.replace("()", "");
            s.replace("[]", "");
            s.replace("{}", "");
        }
        if (s.length() > 0) {
            return false;
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
        System.out.println(isValid("{"));

    }

}
