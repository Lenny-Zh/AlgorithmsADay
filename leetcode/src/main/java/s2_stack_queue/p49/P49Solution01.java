package s2_stack_queue.p49;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P49Solution01 {


    /**
     * 1. 暴力 多次遍历对比
     * 2.
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String idx : strs) {
            char[] chars = idx.toCharArray();
            Arrays.sort(chars);
            String nIdx = new String(chars);
            System.out.println(nIdx);

            List<String> res = map.get(nIdx);
            if (res == null) {
                res = new ArrayList<>();
            }
            res.add(idx);
            map.put(nIdx, res);
        }

        return new ArrayList<>(map.values());
    }

    @Test
    public void test() {
        System.out.println(groupAnagrams(new String[]{ "eat","tea","tan","ate","nat","bat"}));
    }
}
