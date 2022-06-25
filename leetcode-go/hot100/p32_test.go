package hot100

import (
	"fmt"
	"testing"
)

func TestP32(t *testing.T) {
	fmt.Printf("%v", res)
	fmt.Println("\nok")
}

// 升序排列
func search(nums []int, target int) int {
	left, right, mid := 0, len(nums)-1, 0
	for left < right {
		mid = (right + left) / 2

		if nums[left] <= nums[mid] && nums[left] <= target && target <= nums[mid] {
			// 理想情况, 左边递增, target 落中间
			right = mid
		} else if nums[left] > nums[mid] && (nums[left] <= target || target <= nums[mid]) {
			// 第二种情况, 发生了翻转
			right = mid
		} else {
			left = mid + 1 // 其余情况左边界右移
		}

	}
	if left == right && nums[left] == target {
		return left
	} else {
		return -1
	}
}
