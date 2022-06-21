package array

import (
	"fmt"
	"testing"
)

func TestSearch(t *testing.T) {
	nums := []int{-1, 0, 3, 5, 9, 12}
	tar := 3
	br := search_ds(nums, tar)
	fmt.Println(br)
}

func search(nums []int, target int) int {
	for i, num := range nums {
		if target == num {
			return i
		}
	}
	return -1
}

// 二分

func search_br(nums []int, target int) int {
	if len(nums) == 0 {
		return -1
	}
	mid := len(nums) / 2
	for _, _ = range nums {
		if nums[mid] > target {
			mid = mid / 2
		} else if nums[mid] < target {
			mid = mid + (len(nums)-mid)/2
		} else {
			return mid
		}
	}
	return -1
}

func search_ds(nums []int, target int) int {
	high := len(nums) - 1
	low := 0
	for low <= high {
		mid := low + (high-low)/2
		if nums[mid] == target {
			return mid
		} else if nums[mid] > target {
			high = mid - 1
		} else {
			low = mid + 1
		}
	}
	return -1
}
