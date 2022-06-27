package hot100

import (
	"fmt"
	"sort"
	"testing"
)

func TestP34(t *testing.T) {
	arr := []int{5, 7, 7, 8, 8, 10}
	tar := 8
	//fmt.Printf("%v", searchRange(arr, tar))
	//fmt.Println("\nok")
	fmt.Printf("%v\n", binarySearchRight(arr, tar))
}

func TestSortSearch(t *testing.T) {
	rightmost := sort.SearchInts([]int{5, 7, 7, 8, 8, 10}, 9)
	fmt.Println(rightmost)
}

func searchRange(nums []int, target int) []int {
	leftIdx := binarySearch(nums, target, true)
	rightIdx := binarySearch(nums, target, false) - 1
	if leftIdx < rightIdx && rightIdx < len(nums) && nums[leftIdx] == target && nums[rightIdx] == target {
		return []int{leftIdx, rightIdx}
	}
	return []int{-1, -1}
}

func binarySearch(nums []int, target int, lower bool) int {
	left, right, ans := 0, len(nums)-1, len(nums)
	for left <= right {
		mid := (left + right) / 2
		if nums[mid] > target || (lower && nums[mid] >= target) {
			right = mid - 1
			ans = mid
		} else {
			left = mid + 1
		}
	}
	return ans
}

func searchRangeOffi(nums []int, target int) []int {
	leftmost := sort.SearchInts(nums, target)
	if leftmost == len(nums) || nums[leftmost] != target {
		return []int{-1, -1}
	}
	rightmost := sort.SearchInts(nums, target+1) - 1
	return []int{leftmost, rightmost}
}

func binarySearchLeft(nums []int, target int) int {
	left, right, ans := 0, len(nums)-1, len(nums)
	for left <= right {
		mid := (left + right) / 2
		if nums[mid] >= target {
			right = mid - 1
			ans = mid
		} else {
			left = mid + 1
		}
	}
	return ans
}

func binarySearchRight(nums []int, target int) int {
	left, right, ans := 0, len(nums)-1, len(nums)
	for left <= right {
		mid := (left + right) / 2
		if nums[mid] > target {
			right = mid - 1
			ans = mid
		} else {
			left = mid + 1
		}
	}
	return ans
}
