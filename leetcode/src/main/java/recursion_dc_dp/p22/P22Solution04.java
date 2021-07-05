package recursion_dc_dp.p22;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
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
public class P22Solution04 {

    // 动态规划
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();


        return res;
    }


    @Test
    public void test() {
        System.out.println(JSON.toJSON(generateParenthesis(3)));
    }
}
