package hot100

import (
	"fmt"
	"testing"
)

func TestP62(t *testing.T) {
	//fmt.Printf("%v", merge56([][]int{{1, 3}, {2, 6}, {8, 10}, {15, 18}}))
	fmt.Printf("%v", uniquePaths(3, 7))
}

func uniquePaths(m int, n int) int {
	if m == 0 && n == 0 {
		return 0
	}
	if m == 1 || n == 1 {
		return 1
	}
	dp := make([]int, n)
	dp[0] = 1
	for i := 0; i < m; i++ {
		for j := 1; j < n; j++ {
			dp[j] += dp[j-1]
		}
	}
	return dp[n-1]
}
