package hot100

import (
	"fmt"
	"testing"
)

func TestP21(t *testing.T) {
	res := mergeTwoLists(
		&ListNode{1, &ListNode{2, &ListNode{Val: 4}}},
		&ListNode{1, &ListNode{3, &ListNode{Val: 4}}})
	fmt.Printf("%v", res)
	fmt.Println("ok")
}

var head *ListNode
var tail *ListNode

func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
	head = nil
	tail = nil
	for list1 != nil || list2 != nil {
		if list1 != nil && list2 != nil {
			if list1.Val < list2.Val {
				Merge(list1)
				list1 = list1.Next
			} else {
				Merge(list2)
				list2 = list2.Next
			}
		} else if list1 != nil {
			Merge(list1)
			list1 = list1.Next
		} else if list2 != nil {
			Merge(list2)
			list2 = list2.Next
		}
	}
	return head
}

func Merge(node *ListNode) {
	if head == nil {
		head = &ListNode{Val: node.Val}
		tail = head
	} else {
		tail.Next = &ListNode{Val: node.Val}
		tail = tail.Next
	}
}
