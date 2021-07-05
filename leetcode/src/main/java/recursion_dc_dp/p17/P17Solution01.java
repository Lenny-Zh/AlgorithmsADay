package recursion_dc_dp.p17;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 2 abc
 * 3 def
 * 4 ghi
 * 5 jkl
 * 6 mno
 * 7 pqrs
 * 8 tuv
 * 9 wxyz
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 *
 * <p>
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class P17Solution01 {

    // 分治
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0 || "1".equals(digits)) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        map.put("2", Arrays.asList("a", "b", "c"));
        map.put("3", Arrays.asList("d", "e", "f"));
        map.put("4", Arrays.asList("g", "h", "i"));
        map.put("5", Arrays.asList("j", "k", "l"));
        map.put("6", Arrays.asList("m", "n", "o"));
        map.put("7", Arrays.asList("p", "q", "r", "s"));
        map.put("8", Arrays.asList("t", "u", "v"));
        map.put("9", Arrays.asList("w", "x", "y", "z"));

        List<List<String>> arr = new ArrayList<>();
        for (char s : digits.toCharArray()) {
            arr.add(map.get(s + ""));
        }
        List<String> res = new ArrayList<>();
        dc(res, "", 0, arr);
        return res;
    }


    public void dc(List<String> res, String str, int idx, List<List<String>> arr) {
        if (idx == arr.size()) {
            res.add(str);
            return;
        }

        for (int i = 0; i < arr.get(idx).size(); i++) {
            dc(res, str + arr.get(idx).get(i), idx + 1, arr);
        }
    }

    @Test
    public void test() {
        System.out.println(letterCombinations("23"));
    }
}
