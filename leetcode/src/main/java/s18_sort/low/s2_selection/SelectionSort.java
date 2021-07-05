package s18_sort.low.s2_selection;

import com.alibaba.fastjson.JSON;

/**
 * 选择排序（Selection Sort）
 * 选择排序(Selection-sort)是一种简单直观的排序算法。
 * 它的工作原理：
 * 先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 * <p>
 * n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：
 * <p>
 * 初始状态：无序区为R[1..n]，有序区为空；
 * 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
 * n-1趟结束，数组有序化了。
 */
public class SelectionSort {

    public static void selectionSort(Integer[] arr) {
        int len = arr.length;
        int idx = 0;
        for (int i = 0; i < len; i++) {
            int max = arr[i];
            // 找 max  / min
            for (int j = i + 1; j < len; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = max;
            arr[idx] = temp;
        }
    }

    public static void main(String[] args) {
        int i = 9;
        Integer[] arr = new Integer[10];
        while (i >= 0) {
            arr[i--] = (int) (Math.random() * 100);
        }
        System.out.println(JSON.toJSON(arr));
        selectionSort(arr);
        System.out.println(JSON.toJSON(arr));


    }
}
