package hot100

import (
	"fmt"
	"testing"
)

// 给你一个字符串 s，找到 s 中最长的回文子串。
func TestP5(t *testing.T) {
	fmt.Println(longestPalindrome("babad"))

}

// 双指针
func longestPalindrome(s string) string {
	length := len(s)
	if length <= 1 {
		return s
	}
	res := ""
	flag := Get2DBoolArray(length, length)
	// 宽度从0开始, 如果 a是回文
	for width := 0; width < length; width++ {
		for i := 0; i < length-width; i++ {
			j := i + width
			if width == 0 {
				flag[i][j] = true
			} else if width == 1 && s[i] == s[j] {
				flag[i][j] = true
			} else if width > 1 && s[i] == s[j] && flag[i+1][j-1] {
				flag[i][j] = true
			}
			if flag[i][j] && width >= len(res) {
				res = s[i : j+1]
			}
		}
	}
	return res
}
