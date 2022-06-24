package hot100

import (
	"fmt"
	"testing"
)

func TestP19(t *testing.T) {
	fmt.Println(isValidR("()"))
}

func isValid(s string) bool {
	n := len(s)
	if n%2 == 1 {
		return false
	}
	pairs := map[byte]byte{
		')': '(',
		']': '[',
		'}': '{',
	}
	stack := []byte{}
	for i := 0; i < n; i++ {
		if pairs[s[i]] > 0 {
			if len(stack) == 0 || stack[len(stack)-1] != pairs[s[i]] {
				return false
			}
			// 出栈
			stack = stack[:len(stack)-1]
		} else {
			// 进栈
			stack = append(stack, s[i])
		}
	}
	return len(stack) == 0
}

func isValidR(s string) bool {
	if len(s)%2 == 1 {
		return false
	}
	pairs := map[byte]byte{
		')': '(',
		']': '[',
		'}': '{',
	}
	stack := []byte{}
	for i := 0; i < len(s); i++ {
		if pairs[s[i]] > 0 {
			if len(stack) == 0 {
				return false
			}
			if stack[len(stack)-1] != pairs[s[i]] {
				return false
			}

			stack = stack[:len(stack)-1]
		} else {
			// 进展
			stack = append(stack, s[i])
		}
	}
	return len(stack) == 0
}
