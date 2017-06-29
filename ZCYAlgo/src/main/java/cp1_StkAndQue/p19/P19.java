package main.java.cp1_StkAndQue.p19;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/3/29 0029.
 * 一个数组arr , 一个长度为w的窗口, 窗口依次从数组从左向右滑动, 每次移动一格,
 * 如果数组长度为n , 窗口长度w, 一共产生 n-w+1 种情况 , n-w+1个窗口中最大值
 * 实现函数
 * 输入:整形数组 , 窗口大小w
 * 输出:n-w+1的数组res , 是每次移动最大值的集合
 * 难度:尉 * *
 */
public class P19 {
    Integer[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    Integer[] arr2 = {1,3,5,2,7,6,9,8,3,5,4,7,2,5,8,9,5,6,3,1,5,7};
    Integer[] arrdemo = {4,3,5,4,3,3,6,7};
    Integer w = 2;

    @Test
    public void testArr(){
        solutionV1(arrdemo, 3);
    }

    // my method v 1.0 时间复杂度 O（ (n-w+1）* w) = O(w^2)
    private void solutionV1(Integer[] arr , Integer w){
        if (w<1) System.out.println("input error , w must bigger than 0");
        else if( w == 1) {
            System.out.println("res array is " + Arrays.toString(arr));
        }
        else {
            Integer[] res = new Integer[arr.length-w+1];
            // 　n-w+1  times
            for(int index = 0 ; index < (arr.length-w+1); index ++){
                res[index] = 0;
                Integer[] comp = new Integer[w];
                comp = Arrays.copyOfRange(arr, index , index + w);
                // w times
                for (int a=0 ; a < w; a++){
                    if (comp[a] > res[index]){
                        res[index]=comp[a];
                    }
                }
            }
            System.out.println("res array is " + Arrays.toString(res));
        }
    }

    // 书中方法 时间复杂度 O（n）
    private void solutionV2(Integer[] arr , Integer w){
        LinkedList<Integer> res = new LinkedList<Integer>();



        for (int i=0 ; i < arr.length;i++){

        }
    }
}








