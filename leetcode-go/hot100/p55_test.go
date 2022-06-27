package hot100

import (
	"fmt"
	"testing"
)

func TestP55(t *testing.T) {
	fmt.Printf("%v", canJump([]int{2, 3, 1, 1, 4}))
}

func canJump(nums []int) bool {
	res := 0
	for i := 0; i < len(nums); i++ {
		if i <= res {
			if i+nums[i] > res {
				res = i + nums[i]
			}
			if res >= len(nums)-1 {
				return true
			}
		}
	}
	return false
}
