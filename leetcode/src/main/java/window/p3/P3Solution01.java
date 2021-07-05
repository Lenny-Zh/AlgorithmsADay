package window.p3;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class P3Solution01 {


    public int lengthOfLongestSubstring(String s) {
        Integer max = 0;
        Integer left = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i <s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max, map.get(s.charAt(i)) - left + 1);

        }
        return max;
    }

    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring("abcabcabc"));
    }

    public static void main(String[] args) {
        // 1.  0 -> 4999
        int cnt = 8;
        int number = 0;
        int totalGet =0;
        while (cnt-- > 0) {
            totalGet+=incr(number, (number += 601));
        }
        System.out.println(number);
        System.out.println(totalGet);
    }


    public static int incr(int old, int newNum) {
//        if (old < 200 && newNum >= 200) {
//            int cnt = newNum / 200;
//            System.out.println(old + " " + newNum + " 获得一次抽奖机会");
//        } else {
        int cnt = (newNum / 200) - (old / 200);
        if (cnt > 0) {
            System.out.println(old + " " + newNum + " 获得" + cnt + "次抽奖机会");
            return cnt;
        }
//        }
        return 0;
    }
}


