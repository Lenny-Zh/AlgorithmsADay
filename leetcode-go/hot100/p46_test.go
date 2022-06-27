package hot100

import (
	"fmt"
	"testing"
)

func TestP46(t *testing.T) {
	fmt.Printf("%v", combinationSum([]int{2, 3, 6, 7}, 7))
}

func permute(nums []int) [][]int {
	res := make([][]int, 0)
	cur := make([]int, 0)
	backtrack(nums, &res, &cur)
	return res
}

func backtrack(nums []int, res *[][]int, cur *[]int) {
	if len(*cur) == len(nums) {
		temp := make([]int, 0)
		temp = append(temp, *cur...)
		*res = append(*res, temp)
	}

	for i := 0; i < len(nums); i++ {
		if ContainsInteger(*cur, nums[i]) {
			continue
		}
		*cur = append(*cur, nums[i])
		backtrack(nums, res, cur)
		*cur = (*cur)[0 : len((*cur))-1]
	}
}

func ContainsInteger(src []int, dst int) bool {
	for _, i := range src {
		if i == dst {
			return true
		}
	}
	return false
}
