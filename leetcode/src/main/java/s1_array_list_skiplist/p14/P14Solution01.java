package s1_array_list_skiplist.p14;

import com.alibaba.fastjson.JSON;
import org.junit.Test;


// 方法一：横向扫描
public class P14Solution01 {


    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String last = null;
        for (String str : strs) {
            if (last == null) {
                last = str;
            } else {
                last = getCom(last, str);
            }
        }
        return last;
    }

    public String getCom(String sub1, String sub2) {
        int len = Math.min(sub1.length(), sub2.length());
        int idx = 0;
        while (idx < len && sub1.charAt(idx) == sub2.charAt(idx)) {
            idx++;
        }
        return sub1.substring(0,idx);
    }


    @Test
    public void test() {
        String[] strs = {"flower", "flow", "flight"};
        String res = longestCommonPrefix(strs);
        System.out.println(JSON.toJSONString(res));
    }


}
