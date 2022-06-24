package hot100

import (
	"fmt"
	"sort"
	"testing"
)

func TestP15(t *testing.T) {
	go func() {
		go PrintDemo(10)
		go PrintDemo(20)
		go PrintDemo(30)
		fmt.Println("退出")
		return
	}()

	PrintDemo(60)

}

func PrintDemo(total int) {
	for i := 0; i < total; i++ {
		fmt.Println(i)
	}
}

func threeSum(nums []int) [][]int {
	if len(nums) < 3 {
		return [][]int{}
	}
	// sort
	sort.Ints(nums)

	res := Get2DIntArray(len(nums), len(nums))
	for i := 0; i < len(nums); i++ {
		// 已经排序, >0 表示不可能了
		if nums[i] > 0 {
			break
		}
		// 去除重复的组合
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		//
		left := i + 1
		right := len(nums) - 1

		for left < right {
			sum := nums[i] + nums[left] + nums[right]
			if sum == 0 {
				res = append(res, []int{nums[i], nums[left], nums[right]})
				// 去重
				for left < right && nums[left] == nums[left+1] {
					left++
				}
				// 去重
				for left < right && nums[right] == nums[right-1] {
					right--
				}
				left++
			} else if sum > 0 {
				right--
			} else {
				left++
			}
		}
	}
	return res
}

func threeSumR(nums []int) [][]int {
	if len(nums) < 3 {
		return [][]int{}
	}

	sort.Ints(nums)
	res := make([][]int, 0)
	for i := 0; i < len(nums); i++ {
		if nums[i] > 0 {
			break
		}

		if i > 0 && nums[i] == nums[i-1] {
			continue
		}

		left := i + 1
		right := len(nums) - 1
		for left < right {
			sum := nums[i] + nums[left] + nums[right]
			if sum == 0 {
				res = append(res, []int{nums[i], nums[left], nums[right]})
				for left < right && nums[left] == nums[left+1] {
					left++
				}
				for left < right && nums[right] == nums[right-1] {
					right--
				}
				left++
			} else if sum > 0 {
				right--
			} else {
				left++
			}
		}
	}
	return res
}
