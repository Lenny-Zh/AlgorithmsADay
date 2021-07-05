package s2_stack_queue.p242;

import org.junit.Test;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P242Solution03 {

    /**
     *  1. 排序对比
     *  2. hashmap , 遍历第一个 重复元素 value +1, 遍历第二个 元素减1 看最后是否相等
     *
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int arr[] = new int[26];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            arr[sArr[i] - 'a']++;
            arr[tArr[i] - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(isAnagram("anagram","nagaram"));
    }


}
