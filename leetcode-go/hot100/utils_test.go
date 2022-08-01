package hot100

import (
	"fmt"
	"testing"
)

func TestSortArray(t *testing.T) {
	arr := []int{1, 45, 67, 782}
	SortArrayAes(arr)
	fmt.Println(arr)

	SortArrayDes(arr)
	fmt.Println(arr)

	arr2D := [][]int{{1, 3}, {9, 10}, {4, 6}}
	Sort2DArrayAesByFirstNumbers(arr2D)
	fmt.Println(arr2D)
}
