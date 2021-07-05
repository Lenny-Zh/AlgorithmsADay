package recursion_dc_dp.p22;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class P22Solution03 {

    // 递归
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recurison(res, "", n - 1, n - 1);
        return res;
    }

    public void recurison(List<String> res, String str, int left, int right) {
        if (left == 0 && right == 0) {
            res.add("(" + str + ")");
            return;
        }
        if (left > 0) recurison(res, str + "(", left - 1, right);
        if (right >= left) recurison(res, str + ")", left, right - 1);
    }


    @Test
    public void test() {
        System.out.println(JSON.toJSON(generateParenthesis(3)));
    }

    public static void main(String[] args) {
        List<String> abilityList = Arrays.asList("A1", "A2", "A3", "A4", "A5");
        List<String> youngList = Arrays.asList("Y1", "Y2", "Y3", "Y4", "Y5");
        List<String> bueatyList = Arrays.asList("B1", "B2", "B3", "B4", "B5");
        for (String a : abilityList) {
            for (String y : youngList) {
                for (String b : bueatyList) {
                    System.out.println(a + "\t" + y + "\t" + b
                            + "\t" + (abilityList.indexOf(a) + 1 + youngList.indexOf(y) + 1 + bueatyList.indexOf(b) + 1));
                }
            }
        }
    }
}
