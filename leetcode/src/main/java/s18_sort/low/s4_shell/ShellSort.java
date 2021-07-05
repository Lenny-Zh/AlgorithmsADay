package s18_sort.low.s4_shell;

import com.alibaba.fastjson.JSON;

/**
 * 1959年Shell发明，第一个突破O(n2)的排序算法，是简单插入排序的改进版。
 * 它与插入排序的不同之处在于，它会优先比较距离较远的元素。
 * 希尔排序又叫缩小增量排序。
 * <p>
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
 * <p>
 * 1.选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 * 2.按增量序列个数k，对序列进行k 趟排序；
 * 3.每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
 * 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 */
public class ShellSort {

    public static void shellSort(Integer[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int idx = i - 1;
            int temp = arr[i];
            while (idx >= 0 && arr[idx] < temp) {
                arr[idx + 1] = arr[idx];
                idx--;
            }
            arr[idx + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int i = 9;
        Integer[] arr = new Integer[10];
        while (i >= 0) {
            arr[i--] = (int) (Math.random() * 100);
        }
        System.out.println(JSON.toJSON(arr));
        shellSort(arr);
        System.out.println(JSON.toJSON(arr));
    }


}
