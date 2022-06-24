package hot100

import (
	"fmt"
	"strconv"
	"strings"
	"testing"
)

func TestP17(t *testing.T) {
	combinations := letterCombinations("2")
	fmt.Printf("%v\n", combinations)
}

var mp = [][]string{
	{}, {},
	{"a", "b", "c"},
	{"d", "e", "f"},
	{"g", "h", "i"},
	{"j", "k", "l"},
	{"m", "n", "o"},
	{"p", "q", "r", "s"},
	{"t", "u", "v"},
	{"w", "x", "y", "z"}}

var res = []string{}
var sb = strings.Builder{}

func letterCombinations(digits string) []string {
	if len(digits) == 0 || "1" == digits {
		return []string{}
	}
	bt(digits, 0)
	return res
}

func bt(digits string, startIdx int) {
	if sb.Len() == len(digits) {
		res = append(res, sb.String())
		return
	}
	s := string(digits[startIdx])
	idx, _ := strconv.Atoi(s)
	arr := mp[idx]

	for i := 0; i < len(arr); i++ {
		sb.WriteString(arr[i])
		bt(digits, startIdx+1)
		str := sb.String()
		if len(str) > 0 {
			str = str[:len(str)-1]
			sb.Reset()
			sb.WriteString(str)
		}
	}
}

// return

func letterCombinationsR(digits string) []string {
	if len(digits) == 0 || "0" == digits || "1" == digits {
		return []string{}
	}
	btR(digits, 0)
	return res
}

func btR(digits string, startIdx int) {
	// 本层满足条件 ,添加
	if sb.Len() == len(digits) {
		res = append(res, sb.String())
		return
	}

	mpIdx, _ := strconv.Atoi(string(digits[startIdx]))
	letterArr := mp[mpIdx]
	if len(letterArr) == 0 {
		return
	}
	// 本层加值, 进入下一层, 回来把本层的数值删掉
	for i := 0; i < len(letterArr); i++ {
		sb.WriteString(letterArr[i])
		btR(digits, startIdx+1)
		if len(sb.String()) > 0 {
			s := sb.String()
			sb.Reset()
			sb.WriteString(s[:len(s)-1])
		}
	}
}
