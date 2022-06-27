package hot100

import (
	"fmt"
	"math"
	"testing"
)

func TestP42(t *testing.T) {
	fmt.Printf("%v", combinationSum([]int{2, 3, 6, 7}, 7))
}

func trap(height []int) int {
	left := 0
	right := len(height) - 1

	leftHight := 0
	rightHight := 0
	res := 0
	for left < right {
		leftHight = int(math.Max(float64(leftHight), float64(height[left])))
		rightHight = int(math.Max(float64(rightHight), float64(height[right])))

		if leftHight < rightHight {
			res += leftHight - height[left]
			left++
		} else {
			res += rightHight - height[right]
			right--
		}
	}
	return res
}

func trapR(height []int) int {
	left, right := 0, len(height)-1
	leftHight, rightHight := 0, 0
	res := 0
	for left < right {
		leftHight = int(math.Max(float64(leftHight), float64(height[left])))
		rightHight = int(math.Max(float64(rightHight), float64(height[right])))

		if leftHight < rightHight {
			res += leftHight - height[left]
			left++
		} else {
			res += rightHight - height[right]
			right--
		}
	}
	return res
}
