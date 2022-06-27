package hot100

import (
	"fmt"
	"testing"
)

func TestP39(t *testing.T) {
	fmt.Printf("%v", combinationSum([]int{2, 3, 6, 7}, 7))
}

func combinationSum(candidates []int, target int) [][]int {
	res := make([][]int, 0)
	mid := make([]int, 0)
	dfs(candidates, target, &res, 0, &mid)
	return res
}

func dfs(candidates []int, target int, res *[][]int, index int, midArr *[]int) {
	if target == 0 {
		// 浅拷贝
		temp := make([]int, 0)
		temp = append(temp, *midArr...)
		*res = append(*res, temp)
		return
	} else if target < 0 {
		return
	}

	for i := index; i < len(candidates); i++ {
		*midArr = append(*midArr, candidates[i])
		dfs(candidates, target-candidates[i], res, i, midArr)
		*midArr = (*midArr)[0 : len((*midArr))-1]
	}
}
