package hot100

import (
	"fmt"
	"testing"
	"unsafe"
)

/**
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
*/
func TestP3(t *testing.T) {
	fmt.Printf("%v \n", lengthOfLongestSubstring("abcabcbb"))

	//str := "abc"
	//set := make(map[byte]byte, 0)
	//set[str[1]] = str[1]
	//fmt.Printf("%v \n", set)
	//delete(set, str[1])
	//fmt.Printf("%v \n", set)

}

// 双指针
func lengthOfLongestSubstring(s string) int {
	set := make(map[byte]byte, 0)
	max := 0
	left := 0
	for i := 0; i < len(s); i++ {
		str := s[i]
		for {
			if i == 0 {
				break
			}

			_, ok := set[str]
			if !ok {
				break
			}
			delete(set, s[left])
			left++
			continue
		}
		set[str] = str
		if len(set) > max {
			max = len(set)
		}
	}
	return max
}

func str2bytes(s string) []byte {
	x := (*[2]uintptr)(unsafe.Pointer(&s))
	h := [3]uintptr{x[0], x[1], x[1]}
	return *(*[]byte)(unsafe.Pointer(&h))
}
