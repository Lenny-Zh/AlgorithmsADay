package s18_sort.hight.s6_merge;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * 归并排序是建立在归并操作上的一种有效的排序算法。
 * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 * 将已有序的子序列合并，得到完全有序的序列；
 * 即先使每个子序列有序，再使子序列段间有序。
 * 若将两个有序表合并成一个有序表，称为2-路归并。
 * <p>
 * <p>
 * 1.把长度为n的输入序列分成两个长度为n/2的子序列；
 * 2.对这两个子序列分别采用归并排序；
 * 3.将两个排序好的子序列合并成一个最终的排序序列。
 */
public class MergerSort {

    public Integer[] mergeSort(Integer[] arr) {
        if( arr.length < 2) return arr;
        int len = arr.length / 2;
        Integer[] leftArr = new Integer[len];
        Integer[] rightArr = new Integer[arr.length -len];
        System.arraycopy(arr, 0, leftArr, 0, len);
        System.arraycopy(arr, len , rightArr,0 , arr.length -len);
        return merge(mergeSort(leftArr), mergeSort(rightArr));
    }

    private Integer[] merge(Integer[] leftArr, Integer[] rightArr) {
        Integer[] result = new Integer[leftArr.length + rightArr.length];
        int i = 0, j = 0, k = 0;

        while (i < leftArr.length && j < rightArr.length) {
            result[k++] = leftArr[i] < rightArr[j] ?
                    leftArr[i++] : rightArr[j++];
        }

        while (i < leftArr.length) result[k++] = leftArr[i++];
        while (j < rightArr.length) result[k++] = rightArr[j++];

        return result;
    }

    @Test
    public void test() {
        int i = 10;
        Integer[] arr = new Integer[i + 1];
        while (i >= 0) {
            arr[i--] = (int) (Math.random() * 100);
        }
//        Integer[] arr = new Integer[11];
//        arr[0] = 22;
//        arr[1] = 57;
//        arr[2] = 79;
//        arr[3] = 5;
//        arr[4] = 21;
//        arr[5] = 0;
//        arr[6] = 66;
//        arr[7] = 50;
//        arr[8] = 14;
//        arr[9] = 67;
//        arr[10] = 41;

        System.out.println(JSON.toJSON(arr));
        arr = mergeSort(arr);

        System.out.println(JSON.toJSON(arr));

    }
}
