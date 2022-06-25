package hot100

import (
	"fmt"
	"testing"
)

func TestP34(t *testing.T) {
	fmt.Printf("%v", res)
	fmt.Println("\nok")
}

// TODO 头大了
func searchRange(nums []int, target int) []int {
	return nil
}

func binarySearch(nums []int, target int, lower bool) {
	left, right, mid := 0, len(nums)-1, 0
	for left < right {
		mid = (left + right) / 2
		if target < nums[mid] {
			right = mid
		} else if target > nums[mid] || (lower && target >= nums[mid]) {
			left = mid

		} else {
			left++
		}
	}

}
