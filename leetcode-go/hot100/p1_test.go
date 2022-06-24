package hot100

import (
	"fmt"
	"testing"
)

func TestP1(t *testing.T) {
	fmt.Printf("%v\n", twoSum([]int{2, 7, 11, 15}, 9))
}

// 用一个map
func twoSum(nums []int, target int) []int {
	mp := make(map[int]int, 0)
	for idx, num := range nums {
		index, ok := mp[num]
		if ok {
			return []int{index, idx}
		}
		mp[target-num] = idx
	}
	return []int{}
}
