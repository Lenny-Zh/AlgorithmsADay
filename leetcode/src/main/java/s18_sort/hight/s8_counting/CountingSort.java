package s18_sort.hight.s8_counting;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * 计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。
 * 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
 * <p>
 * <p>
 * 1.找出待排序的数组中最大和最小的元素；
 * 2.统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
 * 3.对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
 * 4.反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
 */
public class CountingSort {


    public Integer[] CountingSort(Integer[] arr) {
        Integer max = arr.length;





        return null;
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

        System.out.println(JSON.toJSON(arr));

    }
}
