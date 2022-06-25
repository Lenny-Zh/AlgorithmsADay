package hot100

import (
	"fmt"
	"testing"
)

func TestP23(t *testing.T) {
	//res := mergeKLists(3)
	fmt.Printf("%v", res)
	fmt.Println("\nok")
}

var headP23 *ListNode
var tailP23 *ListNode

// 分治
func mergeKLists(lists []*ListNode) *ListNode {
	if len(lists) == 0 {
		return nil
	}
	return merge(lists)
}

func merge(lists []*ListNode) *ListNode {
	l := len(lists)
	if l == 0 {
		return &ListNode{}
	}
	if l == 1 {
		return lists[0]
	}
	mid := l / 2

	leftList := merge(lists[0:mid])
	rightList := merge(lists[mid : l-1])
	return mergeTwoList(leftList, rightList)
}

func mergeTwoList(list1 *ListNode, list2 *ListNode) *ListNode {
	head = nil
	tail = nil
	for list1 != nil || list2 != nil {
		if list1 != nil && list2 != nil {
			if list1.Val < list2.Val {
				mergeHeadTail(list1)
				list1 = list1.Next
			} else {
				mergeHeadTail(list2)
				list2 = list2.Next
			}
		} else if list1 != nil {
			mergeHeadTail(list1)
			list1 = list1.Next
		} else if list2 != nil {
			mergeHeadTail(list2)
			list2 = list2.Next
		}
	}
	return head
}

func mergeHeadTail(node *ListNode) {
	if headP23 == nil {
		headP23 = &ListNode{Val: node.Val}
		tailP23 = headP23
	} else {
		tailP23.Next = &ListNode{Val: node.Val}
		tailP23 = tailP23.Next
	}
}
