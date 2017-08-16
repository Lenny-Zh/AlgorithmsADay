package cp1_StkAndQue.p19;

import org.junit.Test;

import java.util.*;

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
    int[] arrdemo2 = {4,3,5,4,3,3,6,7};

    Integer w = 2;

    @Test
    public void testArr() {
        solutionV1(arrdemo, 3);
        solutionV2(arrdemo, 3);
        solutionV3(arrdemo, 3);
        getMaxWindow(arrdemo2, 3);
    }

    // my method v 1.0 时间复杂度 O（ (n-w+1）* w) = O(w^2)
    private void solutionV1(Integer[] arr, Integer w) {
        if (w < 1) System.out.println("input error , w must bigger than 0");
        else if (w == 1) {
            System.out.println("res array is " + Arrays.toString(arr));
        } else {
            Integer[] res = new Integer[arr.length - w + 1];
            // 　n-w+1  times
            for (int index = 0; index < (arr.length - w + 1); index++) {
                res[index] = 0;
                Integer[] comp = new Integer[w];
                comp = Arrays.copyOfRange(arr, index, index + w);
                // w times
                for (int a = 0; a < w; a++) {
                    if (comp[a] > res[index]) {
                        res[index] = comp[a];
                    }
                }
            }
            System.out.println("res0 array is " + Arrays.toString(res));
        }
    }

    /**
     * 书中方法 再实现 时间复杂度 O（n）
     * 利用双端队列
     * size = 8
     * 8-3 = 5
 *     Integer[] arrdemo = {4,3,5,4,3,3,6,7};
     *                      0 1 2 3 4 5 6 7
     * */
    private void solutionV2(Integer[] arr, Integer w) {
        Integer[] res = new Integer[arr.length - w + 1];
        Integer resIndex = 0;
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            while (list.size() >= 0) {
                if (list.size() == 0) {
                    break;
                } else {
                    if (arr[i] < arr[list.peekLast()]) {
                        break;
                    } else {
                        list.pollLast();
                    }
                }
            }
            list.add(i);
            if (list.peekFirst() == i - w) {
                Integer pol = list.pollFirst();
            }
            if (i >= w - 1) {
                res[resIndex++] = arr[list.peekFirst()];
            }
        }
        System.out.println("res2 array is " + Arrays.toString(res));
    }

    private void solutionV3(Integer[] arr, Integer w) {
        Integer[] res = new Integer[arr.length - w + 1];
        Integer resIndex = 0;
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            while (!list.isEmpty() && arr[i] >= arr[list.peekFirst()]) {
                list.pollFirst();
            }
            list.add(i);
            if (list.peekFirst() == i - w) {
                Integer pol = list.pollFirst();
            }
            if (i >= w - 1) {
                res[resIndex++] = arr[list.peekFirst()];
            }
        }
        System.out.println("res3 array is " + Arrays.toString(res));
    }

    private void getMaxWindow(int[] arr, int w){
        if (arr == null ||  w< 1 || arr.length < w){
            System.out.println("arr error ! ");
        }
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for( int i = 0 ; i < arr.length; i++){
            while (!qmax.isEmpty() && arr[qmax.peekFirst()] <= arr[i]){
                qmax.pollFirst();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i-w){
                qmax.pollFirst();
            }
            if (i >= w-1 ){
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        System.out.println("resX array is " + Arrays.toString(res));
    }

}








