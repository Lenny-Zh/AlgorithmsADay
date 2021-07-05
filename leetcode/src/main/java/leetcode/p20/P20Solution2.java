package leetcode.p20;


import org.junit.Test;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

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
public class P20Solution2 {

    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        Stack<String> stack = new Stack<>();

        String l1 = "(";
        String l2 = "{";
        String l3 = "[";

        String r1 = ")";
        String r2 = "}";
        String r3 = "]";

        Set<String> openSet = new HashSet<>();
        openSet.add(l1);
        openSet.add(l2);
        openSet.add(l3);

        Set<String> closeSet = new HashSet<>();
        closeSet.add(r1);
        closeSet.add(r2);
        closeSet.add(r3);


        char[] arr = s.trim().toCharArray();

        if (arr.length % 2 == 1) {
            return false;
        }

        int openCnt = 0;

        for (int i = 0; i < arr.length; i++) {
            String str = arr[i] + "";
            if (openSet.contains(str)) {
                stack.add(str);
                openCnt++;
                continue;
            }

            if (closeSet.contains(str)) {
                if (stack.isEmpty()) {
                    return false;
                }
                String peek = stack.peek();
                if ((str.equals(r1) && peek.equals(l1))
                        || (str.equals(r2) && peek.equals(l2))
                        || (str.equals(r3) && peek.equals(l3))) {
                    openCnt--;
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }
        }
        if (openCnt != 0) {
            return false;
        }
        return true;
    }

    @Test
    public void test() {
//        System.out.println(isValid("()"));
//        System.out.println(isValid("()[]{}"));
//        System.out.println(isValid("(]"));
//        System.out.println(isValid("([)]"));
//        System.out.println(isValid("(){}}{"));
//        System.out.println(isValid("{[]}"));
        System.out.println(isValid("{"));

    }

}
