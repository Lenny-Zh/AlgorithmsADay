package s1_array_list_skiplist.p344;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 */
public class P344Solution01 {

    //
    public void reverseString(char[] s) {
        int last = s.length - 1;
        for (int i = 0; i < s.length; i++) {
            if (i < last && i != last) {
                char temp = s[i];
                s[i] = s[last];
                s[last] = temp;
                last--;
            }
        }
    }


}
