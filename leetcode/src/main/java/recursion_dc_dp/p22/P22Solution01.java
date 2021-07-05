package recursion_dc_dp.p22;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class P22Solution01 {

    // 递归
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recurison(res, "", n, n);
        return res;
    }

    public void recurison(List<String> res, String str, int left, int right) {
        if (left == 0 && right == 0) {
            // 检查合格
            char[] chars = str.toCharArray();
            Stack<String> stack = new Stack<String>();
            for (char s : chars) {
                if (!stack.isEmpty() && "(".equals(stack.peek()) && ")".equals(s + "")) {
                    stack.pop();
                } else {
                    stack.push(s + "");
                }
            }
            if(stack.isEmpty()){
                res.add(str);
            }
            return;
        }
        if (left > 0) {
            recurison(res, str + "(", left - 1, right);
        }
        if (right > 0) {
            recurison(res, str + ")", left, right - 1);
        }
    }


    @Test
    public void test() {
        System.out.println(JSON.toJSON(generateParenthesis(3)));
    }
}
