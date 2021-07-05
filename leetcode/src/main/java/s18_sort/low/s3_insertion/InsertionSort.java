package s18_sort.low.s3_insertion;

import com.alibaba.fastjson.JSON;

/**
 * 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。
 * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 * <p>
 * 3.1 算法描述
 * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
 * <p>
 * 从第一个元素开始，该元素可以认为已经被排序；
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 将新元素插入到该位置后；
 * 重复步骤2~5。
 */
public class InsertionSort {

    public static void insertionSort(Integer[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int idx = i - 1;
            int temp = arr[i];
            while (idx >= 0 && arr[idx] < temp) {
                arr[idx+1] = arr[idx];
                idx--;
            }
            arr[idx+1] = temp;
        }
    }

    public static void main(String[] args) {
        int i = 9;
        Integer[] arr = new Integer[10];
        while (i >= 0) {
            arr[i--] = (int) (Math.random() * 100);
        }
        System.out.println(JSON.toJSON(arr));
        insertionSort(arr);
        System.out.println(JSON.toJSON(arr));
    }


}
