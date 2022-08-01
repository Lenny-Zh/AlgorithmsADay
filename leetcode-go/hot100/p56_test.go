package hot100

import (
	"fmt"
	"testing"
)

func TestP56(t *testing.T) {
	//fmt.Printf("%v", merge56([][]int{{1, 3}, {2, 6}, {8, 10}, {15, 18}}))
	fmt.Printf("%v", merge56([][]int{{1, 4}, {0, 0}}))

}

/**
1. 包含 {1,10}, {4,5}
2. 链接 {1,5} {4,8}
3. 断链 {1,2} {4,6}
*/

func merge56(intervals [][]int) [][]int {
	//sort2DArrayAesByFirstNumbers(intervals)
	length := len(intervals)
	res := Get2DIntArray(length, 2)
	idx := -1
	for _, item := range intervals {
		if idx == -1 || item[0] > res[idx][1] {
			idx++
			res[idx] = item
		} else {
			res[idx][1] = MaxInt(res[idx][1], item[1])
		}
	}
	return res[0 : idx+1]
}

func sort2DArrayAesByFirstNumbers(arr [][]int) {
	for i := 0; i < len(arr); i++ {
		for j := i + 1; j < len(arr); j++ {
			if arr[i][0] > arr[j][0] {
				// 数据交换
				arr[i][0], arr[j][0] = arr[j][0], arr[i][0]
			}
		}
	}
}
