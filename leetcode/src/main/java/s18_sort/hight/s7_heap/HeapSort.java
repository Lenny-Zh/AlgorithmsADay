package s18_sort.hight.s7_heap;

/**
 * 堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。
 * 堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：
 * 即子结点的键值或索引总是小于（或者大于）它的父节点。
 * <p>
 * 将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
 * 将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
 * 由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 */
public class HeapSort {
//
//    public Integer[] heapSort(Integer[] arr) {
//
//    }
//
//    private Integer[] merge(Integer[] leftArr, Integer[] rightArr) {
//
//    }
//
//    @Test
//    public void test() {
//        int i = 10;
//        Integer[] arr = new Integer[i + 1];
//        while (i >= 0) {
//            arr[i--] = (int) (Math.random() * 100);
//        }
////        Integer[] arr = new Integer[11];
////        arr[0] = 22;
////        arr[1] = 57;
////        arr[2] = 79;
////        arr[3] = 5;
////        arr[4] = 21;
////        arr[5] = 0;
////        arr[6] = 66;
////        arr[7] = 50;
////        arr[8] = 14;
////        arr[9] = 67;
////        arr[10] = 41;
//
//        System.out.println(JSON.toJSON(arr));
//
//        System.out.println(JSON.toJSON(arr));
//
//    }
}
