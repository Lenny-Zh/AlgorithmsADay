package hot100

import (
	"testing"
)

// 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
// 返回容器可以储存的最大水量。
// 说明：你不能倾斜容器。
func TestP7(t *testing.T) {

}

func maxArea(height []int) int {
	max := 0
	j := len(height) - 1
	for i := 0; i < j; {
		h := 0
		if height[i] > height[j] {
			h = height[j]
			j--
		} else {
			h = height[i]
			i++
		}
		w := j - i + 1
		if max < h*w {
			max = h * w
		}
	}
	return max
}
