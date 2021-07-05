package s18_sort.hight.s5_quick;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * 快速排序
 * 基本思想：
 * 通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 * <p>
 * 算法描述
 * 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
 * <p>
 * 1.从数列中挑出一个元素，称为 “基准”（pivot）；
 * 2.重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 3.递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 */
public class QuickSort {


    public void quickSort(Integer[] arr, int left, int right) {
        if (left > right) return;
        int pivot = quickHelp(arr, 0, right);
        System.out.println(pivot);

        quickSort(arr, 0, pivot);
        quickSort(arr, pivot + 1, left);

    }

    public int quickHelp(Integer[] arr, int left, int right) {
        if (left == arr.length - 1 || right - left <= 1) return 0;

        int pivot = left;
        int temp = arr[pivot];
        int subend = 0;
        for (int i = left + 1; i < right; i++) {
            if (arr[i] < temp) {
                if (subend == 0) {
                    arr[left] = arr[i];
                    arr[i] = temp;
                    pivot = i;
                } else {
                    subend ++;
                    Integer t = arr[i];
                    for (int j = i; j > pivot; j--) {
                        arr[j] = arr[j - 1];
                    }
                    arr[pivot++] = t;
                }
            } else {
                subend = i;
            }
        }
        return pivot;
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
        quickSort(arr, 0, arr.length);
        System.out.println(JSON.toJSON(arr));

    }


}
