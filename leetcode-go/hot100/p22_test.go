package hot100

import (
	"fmt"
	"testing"
)

func TestP22(t *testing.T) {
	res := generateParenthesis(3)
	fmt.Printf("%v", res)
	fmt.Println("\nok")
}

func generateParenthesis(n int) []string {
	resArr := make([]string, 0)
	recursive(&resArr, "", n-1, n-1)
	return resArr
}

func recursive(res *[]string, str string, left, right int) {
	if left == 0 && right == 0 {
		subStr := fmt.Sprintf("(%v)", str)
		*res = append(*res, subStr)
		return
	}
	if left > 0 {
		recursive(res, str+"(", left-1, right)
	}
	if right >= left && right > 0 {
		recursive(res, str+")", left, right-1)
	}
	fmt.Println(str)
}

///

func generateParenthesisR(n int) []string {
	res := make([]string, 0)
	recursive(&res, "", n-1, n-1)
	return res
}

func recursiveR(res *[]string, str string, left, right int) {
	if left == 0 && right == 0 {
		*res = append(*res, fmt.Sprintf("(%v)", str))
		return
	}

	if left > 0 {
		recursive(res, str+"(", left-1, right)
	}

	if right > 0 && right >= left {
		recursive(res, str+")", left, right-1)
	}
}
