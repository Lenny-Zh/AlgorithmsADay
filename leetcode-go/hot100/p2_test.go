package hot100

import (
	"fmt"
	"testing"
)

/**
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
*/
func TestP2(t *testing.T) {
	//fmt.Printf("%v\n", addTwoNumbers(
	//	&ListNode{2, &ListNode{4, &ListNode{3, nil}}},
	//	&ListNode{5, &ListNode{6, &ListNode{7, nil}}}))

	fmt.Printf("%v\n", addTwoNumbers(
		&ListNode{9, &ListNode{9, &ListNode{9, nil}}},
		&ListNode{9, &ListNode{Val: 9}}))
}

// 用一个map
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	var head *ListNode
	var tail *ListNode

	carry := 0
	for l1 != nil || l2 != nil {
		val1 := 0
		if l1 != nil {
			val1 = l1.Val
			l1 = l1.Next
		}

		val2 := 0
		if l2 != nil {
			val2 = l2.Val
			l2 = l2.Next
		}

		sum := val1 + val2 + carry
		sum, carry = sum%10, sum/10

		if head == nil {
			head = &ListNode{Val: sum}
			tail = head
		} else {
			tail.Next = &ListNode{Val: sum}
			tail = tail.Next
		}
	}
	if carry > 0 {
		tail.Next = &ListNode{Val: carry}
	}
	return head
}
